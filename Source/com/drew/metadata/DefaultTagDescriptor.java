/*
 * Copyright 2002-2011 Drew Noakes
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 * More information about this project is available at:
 *
 *    http://drewnoakes.com/code/exif/
 *    http://code.google.com/p/metadata-extractor/
 */
package com.drew.metadata;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;

/**
 * A default implementation of the abstract TagDescriptor.  As this class is not coded with awareness of any metadata
 * tags, it simply reports tag names using the format 'Unknown tag 0x00' (with the corresponding tag number in hex)
 * and gives descriptions using the default string representation of the value.
 *
 * @author Drew Noakes http://drewnoakes.com
 */
public class DefaultTagDescriptor extends TagDescriptor<Directory>
{
    public DefaultTagDescriptor(@NotNull Directory directory)
    {
        super(directory);
    }

    /**
     * Gets a best-effort tag name using the format 'Unknown tag 0x00' (with the corresponding tag type in hex).
     * @param tagType the tag type identifier.
     * @return a string representation of the tag name.
     */
    @NotNull
    public String getTagName(int tagType)
    {
        String hex = Integer.toHexString(tagType).toUpperCase();
        while (hex.length() < 4) hex = "0" + hex;
        return "Unknown tag 0x" + hex;
    }

    /**
     * Gets the default string representation of the tag's value.
     * @param tagType the tag type identifier.
     * @return a string representation of the tag's value.
     */
    @Nullable
    public String getDescription(int tagType)
    {
        return _directory.getString(tagType);
    }
}