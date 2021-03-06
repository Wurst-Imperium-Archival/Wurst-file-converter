/*
 * Copyright � 2015 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.wurst_client.v1_7_keybind_converter.menu;

import javax.swing.JLabel;

public class WelcomeMenu extends Menu
{
	public WelcomeMenu()
	{
		super("Welcome", null);
		add(new JLabel("<html>"
			+ "<body width=512>"
			+ "<p>This converter will convert your Wurst Client keybinds "
			+ "from the format used in Wurst v1.6.X and older versions to"
			+ " the format used in Wurst v1.7 and newer versions.</p>"));
	}
	
	@Override
	public void showNextMenu()
	{
		showMenu(new LicenseMenu(this));
	}
}
