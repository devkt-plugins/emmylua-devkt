// This is a generated file. Not intended for manual editing.
package com.tang.intellij.devkt.lua.psi.impl;

import com.tang.intellij.devkt.lua.psi.LuaClassMethodDef;
import com.tang.intellij.devkt.lua.psi.LuaClassMethodName;
import com.tang.intellij.devkt.lua.psi.LuaFuncBody;
import com.tang.intellij.devkt.lua.psi.LuaVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;

public class LuaClassMethodDefImpl extends ASTWrapperPsiElement implements LuaClassMethodDef {

	public LuaClassMethodDefImpl(ASTNode node) {
		super(node);
	}

	public void accept(@NotNull LuaVisitor visitor) {
		visitor.visitClassMethodDef(this);
	}

	public void accept(@NotNull PsiElementVisitor visitor) {
		if (visitor instanceof LuaVisitor) accept((LuaVisitor) visitor);
		else super.accept(visitor);
	}

	@Override
	@NotNull
	public LuaClassMethodName getClassMethodName() {
		return findNotNullChildByClass(LuaClassMethodName.class);
	}

	@Override
	@Nullable
	public LuaFuncBody getFuncBody() {
		return findChildByClass(LuaFuncBody.class);
	}

}
