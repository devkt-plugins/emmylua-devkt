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

package com.tang.intellij.devkt.lua.comment

import com.tang.intellij.devkt.lua.comment.psi.LuaDocPsiElement
import com.tang.intellij.devkt.lua.comment.psi.api.LuaComment
import com.tang.intellij.devkt.lua.psi.LuaCommentOwner
import org.jetbrains.kotlin.com.intellij.psi.util.PsiTreeUtil

/**
 *
 * Created by TangZX on 2016/11/24.
 */
object LuaCommentUtil {

	fun findOwner(element: LuaDocPsiElement): LuaCommentOwner? {
		val comment = findContainer(element)
		return if (comment.parent is LuaCommentOwner) comment.parent as LuaCommentOwner else null
	}

	fun findContainer(psi: LuaDocPsiElement): LuaComment {
		var element = psi
		while (true) {
			if (element is LuaComment) {
				return element
			}
			element = element.parent as LuaDocPsiElement
		}
	}

}
