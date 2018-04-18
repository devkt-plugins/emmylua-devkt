package com.tang.intellij.devkt.lua

import com.tang.intellij.devkt.lua.highlighting.*
import com.tang.intellij.devkt.lua.lang.LuaLanguage
import com.tang.intellij.devkt.lua.lang.LuaParserDefinition
import com.tang.intellij.devkt.lua.psi.*
import org.ice1000.devkt.openapi.*
import org.jetbrains.kotlin.com.intellij.psi.PsiElement
import org.jetbrains.kotlin.com.intellij.psi.tree.IElementType

class EmmyLua<T> : ExtendedDevKtLanguage<T>(
		LuaLanguage.INSTANCE,
		LuaParserDefinition()
) {
	override fun satisfies(fileName: String) = fileName.endsWith(".lua") || fileName.endsWith(".lua.txt")

	override val blockComment: Pair<String, String>?
		get() = "--[[" to "--]]"

	override val lineCommentStart: String?
		get() = "--"

	override fun attributesOf(type: IElementType, colorScheme: ColorScheme<T>) = when (type) {
		LuaTypes.DOC_COMMENT -> colorScheme.docComments
		LuaTypes.BLOCK_COMMENT -> colorScheme.blockComments
		LuaTypes.SHORT_COMMENT -> colorScheme.lineComments
		LuaTypes.STRING -> colorScheme.string
		LuaTypes.SEMI -> colorScheme.semicolon
		LuaTypes.COLON -> colorScheme.colon
		LuaTypes.COMMA -> colorScheme.comma
		LuaTypes.NUMBER -> colorScheme.numbers
		LuaStringTypes.NEXT_LINE -> colorScheme.stringEscape
		LuaTypes.LPAREN, LuaTypes.RPAREN -> colorScheme.parentheses
		LuaTypes.LBRACK, LuaTypes.RBRACK -> colorScheme.brackets
		LuaTypes.LCURLY, LuaTypes.RCURLY -> colorScheme.brackets
		LuaTypes.SHEBANG, LuaTypes.SHEBANG_LINE -> colorScheme.metaData
		in DOC_TAG_TOKENS -> colorScheme.docComments
		in PRIMITIVE_TYPE_SET -> colorScheme.keywords
		in KEYWORD_TOKENS -> colorScheme.keywords
		else -> super.attributesOf(type, colorScheme)
	}

	override fun annotate(element: PsiElement, document: AnnotationHolder<T>, colorScheme: ColorScheme<T>) {
		super.annotate(element, document, colorScheme)
		when (element) {
			is LuaFuncDef -> function(element, document, colorScheme)
			is LuaLocalDef -> {
				element.nameList?.run { nameDefList.forEach {
					document.highlight(it, colorScheme.variable)
				} }
			}
		}
	}

	private fun function(element: LuaFuncDef, document: AnnotationHolder<T>, colorScheme: ColorScheme<T>) {
		element.id?.let { document.highlight(it, colorScheme.function) }
	}
}
