// This is a generated file. Not intended for manual editing.
package com.tang.intellij.devkt.lua.psi.impl;

import com.tang.intellij.devkt.lua.psi.LuaFuncBody;
import com.tang.intellij.devkt.lua.psi.LuaFuncDef;
import com.tang.intellij.devkt.lua.psi.LuaVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElement;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;

import static com.tang.intellij.devkt.lua.psi.LuaTypes.ID;

public class LuaFuncDefImpl extends ASTWrapperPsiElement implements LuaFuncDef {

	public LuaFuncDefImpl(ASTNode node) {
		super(node);
	}

	public void accept(@NotNull LuaVisitor visitor) {
		visitor.visitFuncDef(this);
	}

	public void accept(@NotNull PsiElementVisitor visitor) {
		if (visitor instanceof LuaVisitor) accept((LuaVisitor) visitor);
		else super.accept(visitor);
	}

	@Override
	@Nullable
	public LuaFuncBody getFuncBody() {
		return findChildByClass(LuaFuncBody.class);
	}

	@Override
	@Nullable
	public PsiElement getId() {
		return findChildByType(ID);
	}

}
