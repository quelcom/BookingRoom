/**
   Copyright: 2011 Android Aalto

   This file is part of BookingRoom_jush.

   BookingRoom_jush is free software; you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation; either version 3 of the License, or
   (at your option) any later version.

   BookingRoom_jush is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with BookingRoom_jush. If not, see <http://www.gnu.org/licenses/>.
 */

package org.androidaalto.bookingroom.logic;

import org.androidaalto.bookingroom.model.User;
import org.androidaalto.bookingroom.model.db.UserDb;

/**
 * @author jush
 */
public class UserManager {
    public static UserInfo getUser(String email) {
        User user = UserDb.get(email);
        if (user == null) {
            return null;
        }
        return new UserInfo(user.getId(), user.getName(), user.getEmail(), user.getPassword(),
                user.getSalt());
    }

    /**
     * @param admin
     * @param newPassStr
     */
    public static UserInfo updatePassword(UserInfo admin) {
        User user = UserDb.update(admin);
        return new UserInfo(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getSalt());
    }
}
