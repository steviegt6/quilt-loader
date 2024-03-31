/*
 * Fable - quilt-/fabric-loader fork; <https://github.com/steviegt6/fable>
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

package org.quiltmc.loader.impl.entrypoint;

import org.jetbrains.annotations.ApiStatus;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.quiltmc.loader.impl.util.QuiltLoaderInternal;
import org.quiltmc.loader.impl.util.QuiltLoaderInternalType;

@ApiStatus.NonExtendable
@QuiltLoaderInternal(QuiltLoaderInternalType.LEGACY_EXPOSED)
public interface GamePatchContext {

	/** @return A {@link ClassReader} which reads the original class file. */
	ClassReader getClassSourceReader(String className);

	/** @return A {@link ClassNode}, which may have already been modified by another {@link GamePatch}. */
	ClassNode getClassNode(String className);

	void addPatchedClass(ClassNode patchedClass);
}
