// This is a generated file. Not intended for manual editing.
package com.tang.intellij.devkt.lua.psi.impl;

import com.tang.intellij.devkt.lua.psi.LuaTableExpr;
import com.tang.intellij.devkt.lua.psi.LuaTableField;
import com.tang.intellij.devkt.lua.psi.LuaTableFieldSep;
import com.tang.intellij.devkt.lua.psi.LuaVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;
import org.jetbrains.kotlin.com.intellij.psi.util.PsiTreeUtil;

import java.util.List;

public class LuaTableExprImpl extends LuaExprImpl implements LuaTableExpr {

	public LuaTableExprImpl(ASTNode node) {
		super(node);
	}

	public void accept(@NotNull LuaVisitor visitor) {
		visitor.visitTableExpr(this);
	}

	public void accept(@NotNull PsiElementVisitor visitor) {
		if (visitor instanceof LuaVisitor) accept((LuaVisitor) visitor);
		else super.accept(visitor);
	}

	@Override
	@NotNull
	public List<LuaTableField> getTableFieldList() {
		return PsiTreeUtil.getChildrenOfTypeAsList(this, LuaTableField.class);
	}

	@Override
	@NotNull
	public List<LuaTableFieldSep> getTableFieldSepList() {
		return PsiTreeUtil.getChildrenOfTypeAsList(this, LuaTableFieldSep.class);
	}

}
