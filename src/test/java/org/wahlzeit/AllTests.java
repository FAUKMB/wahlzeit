/*
 * AllTests
 * 
 * version 1.0
 * 
 * Date: 4.11.18
 * 
 * License: AGPLv3
 */

package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.wahlzeit.handlers.TellFriendTest;
import org.wahlzeit.model.*;
import org.wahlzeit.utils.*;
import org.wahlzeit.services.*;
import org.wahlzeit.services.mailing.EmailServiceTestSuite;

@RunWith(Suite.class)
@SuiteClasses({TellFriendTest.class, AccessRightsTest.class, CoordinateTest.class, FlagReasonTest.class,
	GenderTest.class, GuestTest.class, PhotoFilterTest.class, TagsTest.class, UserStatusTest.class,
	ValueTest.class, EmailAddressTest.class, LogBuilderTest.class, EmailServiceTestSuite.class, 
	StringUtilTest.class, VersionTest.class})
public class AllTests {

}
