// This is a generated file. Not intended for manual editing.
package com.tang.intellij.devkt.lua.comment.psi.impl;

import com.tang.intellij.devkt.lua.comment.psi.LuaDocAccessModifier;
import com.tang.intellij.devkt.lua.comment.psi.LuaDocVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;

public class LuaDocAccessModifierImpl extends ASTWrapperPsiElement implements LuaDocAccessModifier {

	public LuaDocAccessModifierImpl(ASTNode node) {
		super(node);
	}

	public void accept(@NotNull LuaDocVisitor visitor) {
		visitor.visitAccessModifier(this);
	}

	public void accept(@NotNull PsiElementVisitor visitor) {
		if (visitor instanceof LuaDocVisitor) accept((LuaDocVisitor) visitor);
		else super.accept(visitor);
	}

}
