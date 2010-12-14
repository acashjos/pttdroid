/*
 * Copyright (C) 2010 The pttdroid Open Source Project
 * 
 * This file is part of pttdroid (http://www.code.google.com/p/pttdroid/)
 * 
 * pttdroid is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This source code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this source code; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package ro.ui.pttdroid.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.LinkedList;

import android.util.Log;

public class PhoneIPs {
	
	static private LinkedList<InetAddress> inetAddresses = new LinkedList<InetAddress>(); 

	public static void load() {
		inetAddresses.clear();
		try {
			Enumeration<NetworkInterface> networkInterfaceEnum = NetworkInterface.getNetworkInterfaces();
			
			while(networkInterfaceEnum.hasMoreElements()) {								
				Enumeration<InetAddress> inetAddresseEnum = networkInterfaceEnum.nextElement().getInetAddresses();
				
				while(inetAddresseEnum.hasMoreElements()) {
					inetAddresses.add(inetAddresseEnum.nextElement());
				}
			}
		}
		catch(IOException e) {
			Log.d("MyNetworkInterfaces", e.toString());
		}
	}
	
	public static boolean contains(InetAddress addr) {
		return inetAddresses.contains(addr);
	}
	
}
