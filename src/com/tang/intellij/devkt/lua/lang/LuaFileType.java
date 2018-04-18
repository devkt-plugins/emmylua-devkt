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

package com.tang.intellij.devkt.lua.lang;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.com.intellij.openapi.fileTypes.LanguageFileType;

import javax.swing.*;

/**
 * Created by TangZhiXu on 2015/11/15.
 * Email:272669294@qq.com
 */
public class LuaFileType extends LanguageFileType {

	public static final @NotNull
	LuaFileType INSTANCE = new LuaFileType();

	protected LuaFileType() {
		super(LuaLanguage.INSTANCE);
	}

	@Override
	public @NotNull
	String getName() {
		return "lua";
	}

	@Override
	public @NotNull
	String getDescription() {
		return "Lua language file";
	}

	@Override
	public @NotNull
	String getDefaultExtension() {
		return "lua";
	}

	@Override
	public @NotNull
	Icon getIcon() {
		return LuaIcons.FILE;
	}
}
