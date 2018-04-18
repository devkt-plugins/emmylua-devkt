// This is a generated file. Not intended for manual editing.
package com.tang.intellij.devkt.lua.psi.impl;

import com.tang.intellij.devkt.lua.psi.LuaExprList;
import com.tang.intellij.devkt.lua.psi.LuaLocalDef;
import com.tang.intellij.devkt.lua.psi.LuaNameList;
import com.tang.intellij.devkt.lua.psi.LuaVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;

public class LuaLocalDefImpl extends ASTWrapperPsiElement implements LuaLocalDef {

	public LuaLocalDefImpl(ASTNode node) {
		super(node);
	}

	public void accept(@NotNull LuaVisitor visitor) {
		visitor.visitLocalDef(this);
	}

	public void accept(@NotNull PsiElementVisitor visitor) {
		if (visitor instanceof LuaVisitor) accept((LuaVisitor) visitor);
		else super.accept(visitor);
	}

	@Override
	@Nullable
	public LuaExprList getExprList() {
		return findChildByClass(LuaExprList.class);
	}

	@Override
	@Nullable
	public LuaNameList getNameList() {
		return findChildByClass(LuaNameList.class);
	}

}
