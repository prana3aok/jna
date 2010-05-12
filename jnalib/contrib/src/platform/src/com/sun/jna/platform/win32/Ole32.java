/* Copyright (c) 2007 Timothy Wall, All Rights Reserved
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 */
package com.sun.jna.platform.win32;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.Guid.GUID;
import com.sun.jna.platform.win32.WinNT.HRESULT;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

/**
 * Ole32.dll Interface.
 * @author dblock[at]dblock.org
 */
public interface Ole32 extends StdCallLibrary {
	
	Ole32 INSTANCE = (Ole32) Native.loadLibrary(
			"Ole32", Ole32.class, W32APIOptions.UNICODE_OPTIONS);
	
	/**
	 * Creates a GUID, a unique 128-bit integer used for CLSIDs and interface identifiers. 
	 * @param pguid
	 *  A pointer to the requested GUID.
	 * @return
	 *  S_OK if the GUID was successfully created.
	 */
	HRESULT CoCreateGuid(GUID.ByReference pguid);
	
	/**
	 * Converts a globally unique identifier (GUID) into a string of printable characters. 
	 * @param rguid
	 *  The GUID to be converted.
	 * @param lpsz
	 *  A pointer to a caller-allocated string variable to receive the resulting string.
	 * @param cchMax
	 *  The number of characters available in the lpsz buffer. 
	 * @return
	 *  If the function succeeds, the return value is the number of characters in the 
	 *  returned string, including the null terminator. If the buffer is too small to contain 
	 *  the string, the return value is 0.
	 */
	int StringFromGUID2(GUID.ByReference rguid, char[] lpsz, int cchMax);
	
	/**
	 * Converts a string generated by the StringFromIID function back into the 
	 * original interface identifier (IID).
	 * @param lpsz
	 *  A pointer to the string representation of the IID.
	 * @param lpiid
	 *  A pointer to the requested IID on return.
	 * @return
	 *  This function can return the standard return values E_INVALIDARG, E_OUTOFMEMORY, 
	 *  and S_OK.
	 */
	HRESULT IIDFromString(String lpsz, GUID.ByReference lpiid);
}