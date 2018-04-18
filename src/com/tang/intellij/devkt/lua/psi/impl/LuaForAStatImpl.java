// This is a generated file. Not intended for manual editing.
package com.tang.intellij.devkt.lua.psi.impl;

import com.tang.intellij.devkt.lua.psi.LuaExpr;
import com.tang.intellij.devkt.lua.psi.LuaForAStat;
import com.tang.intellij.devkt.lua.psi.LuaParamNameDef;
import com.tang.intellij.devkt.lua.psi.LuaVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;
import org.jetbrains.kotlin.com.intellij.psi.util.PsiTreeUtil;

import java.util.List;

public class LuaForAStatImpl extends LuaStatementImpl implements LuaForAStat {

	public LuaForAStatImpl(ASTNode node) {
		super(node);
	}

	public void accept(@NotNull LuaVisitor visitor) {
		visitor.visitForAStat(this);
	}

	public void accept(@NotNull PsiElementVisitor visitor) {
		if (visitor instanceof LuaVisitor) accept((LuaVisitor) visitor);
		else super.accept(visitor);
	}

	@Override
	@NotNull
	public List<LuaExpr> getExprList() {
		return PsiTreeUtil.getChildrenOfTypeAsList(this, LuaExpr.class);
	}

	@Override
	@NotNull
	public LuaParamNameDef getParamNameDef() {
		return findNotNullChildByClass(LuaParamNameDef.class);
	}

}
