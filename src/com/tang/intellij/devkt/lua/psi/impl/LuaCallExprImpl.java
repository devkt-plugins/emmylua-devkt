// This is a generated file. Not intended for manual editing.
package com.tang.intellij.devkt.lua.psi.impl;

import com.tang.intellij.devkt.lua.psi.LuaArgs;
import com.tang.intellij.devkt.lua.psi.LuaCallExpr;
import com.tang.intellij.devkt.lua.psi.LuaExpr;
import com.tang.intellij.devkt.lua.psi.LuaVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;

public class LuaCallExprImpl extends LuaExprImpl implements LuaCallExpr {

	public LuaCallExprImpl(ASTNode node) {
		super(node);
	}

	public void accept(@NotNull LuaVisitor visitor) {
		visitor.visitCallExpr(this);
	}

	public void accept(@NotNull PsiElementVisitor visitor) {
		if (visitor instanceof LuaVisitor) accept((LuaVisitor) visitor);
		else super.accept(visitor);
	}

	@Override
	@NotNull
	public LuaArgs getArgs() {
		return findNotNullChildByClass(LuaArgs.class);
	}

	@Override
	@NotNull
	public LuaExpr getExpr() {
		return findNotNullChildByClass(LuaExpr.class);
	}

}
