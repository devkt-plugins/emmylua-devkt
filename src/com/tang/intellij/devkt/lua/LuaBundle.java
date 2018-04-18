/*
 * Copyright (c) 2017. tangzx(love.tangzx@qq.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tang.intellij.devkt.lua;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;
import org.jetbrains.kotlin.com.intellij.CommonBundle;
import org.jetbrains.kotlin.com.intellij.reference.SoftReference;

import java.lang.ref.Reference;
import java.util.ResourceBundle;

public class LuaBundle {
	@NonNls
	private static final String BUNDLE = "LuaBundle";
	private static Reference<ResourceBundle> ourBundle;

	private LuaBundle() {
	}

	public static String message(@NotNull @PropertyKey(resourceBundle = BUNDLE) String key, @NotNull Object... params) {
		return CommonBundle.message(getBundle(), key, params);
	}

	public static @NotNull
	String messageOfNull(@NotNull @PropertyKey(resourceBundle = BUNDLE) String key, @NotNull Object... params) {
		return CommonBundle.message(getBundle(), key, params);
	}

	// Cached loading
	private static ResourceBundle getBundle() {
		ResourceBundle bundle = SoftReference.dereference(ourBundle);
		if (bundle == null) {
			bundle = ResourceBundle.getBundle(BUNDLE);
			ourBundle = new SoftReference<>(bundle);
		}
		return bundle;
	}
}
