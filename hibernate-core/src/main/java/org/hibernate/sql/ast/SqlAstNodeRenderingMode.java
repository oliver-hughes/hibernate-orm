/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.sql.ast;

import org.hibernate.sql.ast.tree.SqlAstNode;

/**
 * The rendering mode to use for {@link org.hibernate.sql.ast.tree.SqlAstNode}.
 *
 * Some functions/contexts require the use of literals/expressions rather than parameters
 * like for example the `char` function in Derby which requires the length as literal.
 *
 * Another example is a function that renders a function argument into a subquery select and group by item.
 * It can use {@link #INLINE_PARAMETERS} so that a database can match such a select item to a group by item.
 * Without this, such queries would result in a query error.
 * 
 * @author Christian Beikov
 * @see SqlAstTranslator#render(SqlAstNode, SqlAstNodeRenderingMode) 
 */
public enum SqlAstNodeRenderingMode {
	/**
	 * Render node as is.
	 */
	DEFAULT,

	/**
	 * Render parameters as literals.
	 * All parameters within the {@link org.hibernate.sql.ast.tree.SqlAstNode} are rendered as literals.
	 */
	INLINE_PARAMETERS,

	/**
	 * Render all nested parameters as literals.
	 * All parameters within the {@link org.hibernate.sql.ast.tree.SqlAstNode} are rendered as literals.
	 */
	INLINE_ALL_PARAMETERS,

	/**
	 * Don't render plain parameters. Render it as literal or as expression.
	 * If the {@link org.hibernate.sql.ast.tree.SqlAstNode} to render is a parameter,
	 * it will be rendered either as literal or wrapped into a semantically equivalent expression
	 * such that it doesn't appear as plain parameter.
	 */
	NO_PLAIN_PARAMETER
}
