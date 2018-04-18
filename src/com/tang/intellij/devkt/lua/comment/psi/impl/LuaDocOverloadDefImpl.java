// This is a generated file. Not intended for manual editing.
package com.tang.intellij.devkt.lua.comment.psi.impl;

import com.tang.intellij.devkt.lua.comment.psi.LuaDocFunctionTy;
import com.tang.intellij.devkt.lua.comment.psi.LuaDocOverloadDef;
import com.tang.intellij.devkt.lua.comment.psi.LuaDocVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;

public class LuaDocOverloadDefImpl extends ASTWrapperPsiElement implements LuaDocOverloadDef {

	public LuaDocOverloadDefImpl(ASTNode node) {
		super(node);
	}

	public void accept(@NotNull LuaDocVisitor visitor) {
		visitor.visitOverloadDef(this);
	}

	public void accept(@NotNull PsiElementVisitor visitor) {
		if (visitor instanceof LuaDocVisitor) accept((LuaDocVisitor) visitor);
		else super.accept(visitor);
	}

	@Override
	@Nullable
	public LuaDocFunctionTy getFunctionTy() {
		return findChildByClass(LuaDocFunctionTy.class);
	}

}
