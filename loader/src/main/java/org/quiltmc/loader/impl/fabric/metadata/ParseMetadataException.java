/*
 * Fable - quilt-/fabric-loader fork; <https://github.com/steviegt6/fable>
 * Copyright (C) 2016  FabricMC
 * Copyright (C) 2024  QuiltMC
 * Copyright (C) 2024  Tomat et al.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.quiltmc.loader.impl.fabric.metadata;


import org.quiltmc.json5.JsonReader;
import org.quiltmc.loader.impl.util.QuiltLoaderInternal;
import org.quiltmc.loader.impl.util.QuiltLoaderInternalType;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@QuiltLoaderInternal(QuiltLoaderInternalType.LEGACY_EXPOSED)
public class ParseMetadataException extends Exception {
	private List<String> modPaths;

	public ParseMetadataException(String message) {
		super(message);
	}

	public ParseMetadataException(String message, JsonReader reader) {
		this(message + " Error was located at: " + reader.locationString());
	}

	public ParseMetadataException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public ParseMetadataException(Throwable t) {
		super(t);
	}

	void setModPaths(String modPath, List<String> modParentPaths) {
		modPaths = new ArrayList<>(modParentPaths);
		modPaths.add(modPath);
	}

	@Override
	public String getMessage() {
		String ret = "Error reading fabric.mod.json file for mod at ";

		if (modPaths == null) {
			ret += "unknown location";
		} else {
			ret += String.join(" -> ", modPaths);
		}

		String msg = super.getMessage();

		if (msg != null) {
			ret += ": "+msg;
		}

		return ret;
	}

	public static class MissingField extends ParseMetadataException {
		public MissingField(String field) {
			super(String.format("Missing required field \"%s\".", field));
		}
	}
}
