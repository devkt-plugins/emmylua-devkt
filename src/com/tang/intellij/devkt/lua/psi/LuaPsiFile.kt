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

package com.tang.intellij.devkt.lua.psi

import com.tang.intellij.devkt.lua.lang.LuaFileType
import com.tang.intellij.devkt.lua.lang.LuaLanguage
import org.jetbrains.kotlin.com.intellij.extapi.psi.PsiFileBase
import org.jetbrains.kotlin.com.intellij.openapi.util.io.FileUtil
import org.jetbrains.kotlin.com.intellij.psi.FileViewProvider
import org.jetbrains.kotlin.com.intellij.psi.PsiElement

/**
 * Created by TangZhiXu on 2015/11/15.
 * Email:272669294@qq.com
 */
open class LuaPsiFile(fileViewProvider: FileViewProvider) : PsiFileBase(fileViewProvider, LuaLanguage.INSTANCE), LuaTypeGuessable {
	override fun getFileType() = LuaFileType.INSTANCE

	override fun setName(name: String): PsiElement {
		return if (FileUtil.getNameWithoutExtension(name) == name) {
			super.setName("$name.${LuaFileType.INSTANCE.defaultExtension}")
		} else super.setName(name)
	}

	val moduleName: String? get() = null
}