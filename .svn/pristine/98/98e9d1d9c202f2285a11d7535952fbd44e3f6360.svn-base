

package org.plazmaforge.framework.util;

import java.util.Vector;


public class StringMatcher {

    
    protected String fPattern;

    protected int fLength;

    protected boolean fIgnoreWildCards;

    protected boolean fIgnoreCase;

    protected boolean fHasLeadingStar;

    protected boolean fHasTrailingStar;

    protected String fSegments[];

    protected int fBound;

    protected static final char fSingleWildCard = 0;

    
    
    
    
    public static class Position {

	public int getStart() {
	    return start;
	}

	public int getEnd() {
	    return end;
	}

	int start;

	int end;

	public Position(int start, int end) {
	    this.start = start;
	    this.end = end;
	}
    }

    public StringMatcher(String pattern, boolean ignoreCase, boolean ignoreWildCards) {
	fBound = 0;
	if (pattern == null) {
	    throw new IllegalArgumentException();
	}
	    
	fIgnoreCase = ignoreCase;
	fIgnoreWildCards = ignoreWildCards;
	fPattern = pattern;
	fLength = pattern.length();
	if (fIgnoreWildCards)
	    parseNoWildCards();
	else
	    parseWildCards();
    }

    public Position find(String text, int start, int end) {
	if (text == null) {
	    throw new IllegalArgumentException();
	}
	    
	int tlen = text.length();
	if (start < 0)
	    start = 0;
	if (end > tlen)
	    end = tlen;
	if (end < 0 || start >= end)
	    return null;
	if (fLength == 0)
	    return new Position(start, start);
	if (fIgnoreWildCards) {
	    int x = posIn(text, start, end);
	    if (x < 0)
		return null;
	    else
		return new Position(x, x + fLength);
	}
	int segCount = fSegments.length;
	if (segCount == 0)
	    return new Position(start, end);
	int curPos = start;
	int matchStart = -1;
	int i;
	for (i = 0; i < segCount && curPos < end; i++) {
	    String current = fSegments[i];
	    int nextMatch = regExpPosIn(text, curPos, end, current);
	    if (nextMatch < 0)
		return null;
	    if (i == 0)
		matchStart = nextMatch;
	    curPos = nextMatch + current.length();
	}

	if (i < segCount)
	    return null;
	else
	    return new Position(matchStart, curPos);
    }

    public boolean match(String text) {
	return match(text, 0, text.length());
    }

    public boolean match(String text, int start, int end) {
	if (text == null) {
	    throw new IllegalArgumentException();
	}
	    
	if (start > end)
	    return false;
	if (fIgnoreWildCards)
	    return end - start == fLength
		    && fPattern.regionMatches(fIgnoreCase, 0, text, start,
			    fLength);
	int segCount = fSegments.length;
	if (segCount == 0 && (fHasLeadingStar || fHasTrailingStar))
	    return true;
	if (start == end)
	    return fLength == 0;
	if (fLength == 0)
	    return start == end;
	int tlen = text.length();
	if (start < 0)
	    start = 0;
	if (end > tlen)
	    end = tlen;
	int tCurPos = start;
	int bound = end - fBound;
	if (bound < 0)
	    return false;
	int i = 0;
	String current = fSegments[i];
	int segLength = current.length();
	if (!fHasLeadingStar) {
	    if (!regExpRegionMatches(text, start, current, 0, segLength))
		return false;
	    i++;
	    tCurPos += segLength;
	}
	if (fSegments.length == 1 && !fHasLeadingStar && !fHasTrailingStar)
	    return tCurPos == end;
	for (; i < segCount; i++) {
	    current = fSegments[i];
	    int k = current.indexOf('\0');
	    int currentMatch;
	    if (k < 0) {
		currentMatch = textPosIn(text, tCurPos, end, current);
		if (currentMatch < 0)
		    return false;
	    } else {
		currentMatch = regExpPosIn(text, tCurPos, end, current);
		if (currentMatch < 0)
		    return false;
	    }
	    tCurPos = currentMatch + current.length();
	}

	if (!fHasTrailingStar && tCurPos != end) {
	    int clen = current.length();
	    return regExpRegionMatches(text, end - clen, current, 0, clen);
	}
	return i == segCount;
    }

    private void parseNoWildCards() {
	fSegments = new String[1];
	fSegments[0] = fPattern;
	fBound = fLength;
    }

    private void parseWildCards() {
	if (fPattern.startsWith("*"))
	    fHasLeadingStar = true;
	if (fPattern.endsWith("*") && fLength > 1
		&& fPattern.charAt(fLength - 2) != '\\')
	    fHasTrailingStar = true;
	Vector temp = new Vector();
	int pos = 0;
	StringBuffer buf = new StringBuffer();
	while (pos < fLength) {
	    char c = fPattern.charAt(pos++);
	    switch (c) {
	    case 92: // '\\'
		if (pos >= fLength) {
		    buf.append(c);
		    break;
		}
		char next = fPattern.charAt(pos++);
		if (next == '*' || next == '?' || next == '\\') {
		    buf.append(next);
		} else {
		    buf.append(c);
		    buf.append(next);
		}
		break;

	    case 42: // '*'
		if (buf.length() > 0) {
		    temp.addElement(buf.toString());
		    fBound += buf.length();
		    buf.setLength(0);
		}
		break;

	    case 63: // '?'
		buf.append('\0');
		break;

	    default:
		buf.append(c);
		break;
	    }
	}
	if (buf.length() > 0) {
	    temp.addElement(buf.toString());
	    fBound += buf.length();
	}
	fSegments = new String[temp.size()];
	temp.copyInto(fSegments);
    }

    protected int posIn(String text, int start, int end) {
	int max = end - fLength;
	if (!fIgnoreCase) {
	    int i = text.indexOf(fPattern, start);
	    if (i == -1 || i > max)
		return -1;
	    else
		return i;
	}
	for (int i = start; i <= max; i++)
	    if (text.regionMatches(true, i, fPattern, 0, fLength))
		return i;

	return -1;
    }

    protected int regExpPosIn(String text, int start, int end, String p) {
	int plen = p.length();
	int max = end - plen;
	for (int i = start; i <= max; i++)
	    if (regExpRegionMatches(text, i, p, 0, plen))
		return i;

	return -1;
    }

    protected boolean regExpRegionMatches(String text, int tStart, String p,
	    int pStart, int plen) {
	while (plen-- > 0) {
	    char tchar = text.charAt(tStart++);
	    char pchar = p.charAt(pStart++);
	    if ((fIgnoreWildCards || pchar != 0)
		    && pchar != tchar
		    && (!fIgnoreCase || Character.toUpperCase(tchar) != Character
			    .toUpperCase(pchar)
			    && Character.toLowerCase(tchar) != Character
				    .toLowerCase(pchar)))
		return false;
	}
	return true;
    }

    protected int textPosIn(String text, int start, int end, String p) {
	int plen = p.length();
	int max = end - plen;
	if (!fIgnoreCase) {
	    int i = text.indexOf(p, start);
	    if (i == -1 || i > max)
		return -1;
	    else
		return i;
	}
	for (int i = start; i <= max; i++)
	    if (text.regionMatches(true, i, p, 0, plen))
		return i;

	return -1;
    }


}
