/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.dialect.sequence;

import org.hibernate.MappingException;

/**
 * Sequence support for {@link org.hibernate.dialect.DerbyDialect}.
 *
 * @author Christian Beikov
 */
public final class DerbySequenceSupport extends DB2SequenceSupport {

	public static final SequenceSupport INSTANCE = new DerbySequenceSupport();

	@Override
	public String getSelectSequencePreviousValString(String sequenceName) throws MappingException {
		return "SYSCS_UTIL.SYSCS_PEEK_AT_SEQUENCE('HIBERNATE_ORM_TEST','" + sequenceName.toUpperCase() + "')";
	}
}
