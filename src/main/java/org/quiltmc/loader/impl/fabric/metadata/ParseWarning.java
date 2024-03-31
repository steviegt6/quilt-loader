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

import org.jetbrains.annotations.Nullable;
import org.quiltmc.loader.impl.util.QuiltLoaderInternal;
import org.quiltmc.loader.impl.util.QuiltLoaderInternalType;

@QuiltLoaderInternal(QuiltLoaderInternalType.LEGACY_EXPOSED)
final class ParseWarning {
	private final String location;
	private final String key;
	private final String reason;

	ParseWarning(String location, String key) {
		this(location, key, null);
	}

	ParseWarning(String location, String key, @Nullable String reason) {
		this.location = location;
		this.key = key;
		this.reason = reason;
	}

	public String getLocation() {
		return this.location;
	}

	public String getKey() {
		return this.key;
	}

	public String getReason() {
		return this.reason;
	}
}
