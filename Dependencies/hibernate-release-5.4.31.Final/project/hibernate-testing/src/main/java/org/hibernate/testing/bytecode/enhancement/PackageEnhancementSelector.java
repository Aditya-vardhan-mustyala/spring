/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.testing.bytecode.enhancement;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Steve Ebersole
 */
@Retention( RetentionPolicy.RUNTIME)
@Target( ElementType.TYPE)
@Inherited
@Repeatable( PackageEnhancementSelectors.class )
public @interface PackageEnhancementSelector {
	String value();

	boolean includeSubPackages() default true;
}
