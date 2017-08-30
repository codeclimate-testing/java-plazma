/*
 * Copyright (C) 2005-2010 Oleh Hapon ohapon@users.sourceforge.net
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
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 * 
 * Oleh Hapon
 * Kyiv, UKRAINE
 * ohapon@users.sourceforge.net
 */

/*
 * Created on 10.01.2004
 *
 */
package org.plazmaforge.framework.sql;

/**
 * @author Oleh Hapon $Id: ResultSetReaderInfo.java,v 1.2 2010/04/28 06:34:42 ohapon Exp $
 */
public class ResultSetReaderInfo {

    private static int LARGE_COLUMN_DEFAULT_READ_LENGTH = 255;

    private int limitRow = -1;

    private boolean readBinary = false;

    private boolean readVarBinary = false;

    private boolean readLongVarBinary = false;

    private boolean readBlobs = false;

    private boolean readCompleteBlobs = false;

    private int readBlobsSize = LARGE_COLUMN_DEFAULT_READ_LENGTH;

    private boolean readClobs = false;

    private boolean readCompleteClobs = false;

    private int readClobsSize = LARGE_COLUMN_DEFAULT_READ_LENGTH;

    private boolean readSQLOther = false;

    private boolean readAllOther = false;

    public boolean isReadBinary() {
	return readBinary;
    }

    public void setReadBinary(boolean readBinary) {
	this.readBinary = readBinary;
    }

    public boolean isReadVarBinary() {
	return readVarBinary;
    }

    public void setReadVarBinary(boolean readVarBinary) {
	this.readVarBinary = readVarBinary;
    }

    public boolean isReadLongVarBinary() {
	return readLongVarBinary;
    }

    public void setReadLongVarBinary(boolean readLongVarBinary) {
	this.readLongVarBinary = readLongVarBinary;
    }

    public boolean isReadBlobs() {
	return readBlobs;
    }

    public void setReadBlobs(boolean readBlobs) {
	this.readBlobs = readBlobs;
    }

    public boolean isReadCompleteBlobs() {
	return readCompleteBlobs;
    }

    public void setReadCompleteBlobs(boolean readCompleteBlobs) {
	this.readCompleteBlobs = readCompleteBlobs;
    }

    public int getReadBlobsSize() {
	return readBlobsSize;
    }

    public void setReadBlobsSize(int readBlobsSize) {
	this.readBlobsSize = readBlobsSize;
    }

    public boolean isReadClobs() {
	return readClobs;
    }

    public void setReadClobs(boolean readClobs) {
	this.readClobs = readClobs;
    }

    public boolean isReadCompleteClobs() {
	return readCompleteClobs;
    }

    public void setReadCompleteClobs(boolean readCompleteClobs) {
	this.readCompleteClobs = readCompleteClobs;
    }

    public int getReadClobsSize() {
	return readClobsSize;
    }

    public void setReadClobsSize(int readClobsSize) {
	this.readClobsSize = readClobsSize;
    }

    public boolean isReadSQLOther() {
	return readSQLOther;
    }

    public void setReadSQLOther(boolean readSQLOther) {
	this.readSQLOther = readSQLOther;
    }

    public boolean isReadAllOther() {
	return readAllOther;
    }

    public void setReadAllOther(boolean readAllOther) {
	this.readAllOther = readAllOther;
    }

    public int getLimitRow() {
	return limitRow;
    }

    public void setLimitRow(int limitRow) {
	this.limitRow = limitRow;
    }

}
