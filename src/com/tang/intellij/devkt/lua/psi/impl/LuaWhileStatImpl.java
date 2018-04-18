// This is a generated file. Not intended for manual editing.
package com.tang.intellij.devkt.lua.psi.impl;

import com.tang.intellij.devkt.lua.psi.LuaExpr;
import com.tang.intellij.devkt.lua.psi.LuaVisitor;
import com.tang.intellij.devkt.lua.psi.LuaWhileStat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;

public class LuaWhileStatImpl extends LuaStatementImpl implements LuaWhileStat {

	public LuaWhileStatImpl(ASTNode node) {
		super(node);
	}

	public void accept(@NotNull LuaVisitor visitor) {
		visitor.visitWhileStat(this);
	}

	public void accept(@NotNull PsiElementVisitor visitor) {
		if (visitor instanceof LuaVisitor) accept((LuaVisitor) visitor);
		else super.accept(visitor);
	}

	@Override
	@Nullable
	public LuaExpr getExpr() {
		return findChildByClass(LuaExpr.class);
	}

}
