package com.designpatterns.structural.decorator;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringDecorator {

	public static void main(String[] args) {
		final MagicString magicString = new MagicString("Magic");
		magicString.getVowels().forEach(System.out::print);
		System.out.println();
		magicString.getConsonants().forEach(System.out::print);
	}
}

class MagicString {
	private final String str;

	public MagicString(final String str) {
		this.str = str;
	}

	// New Functionality
	public Stream<Character> getVowels() {
		return this.str.chars().mapToObj(i -> (char)i).filter(c -> {
			return c == 'A' || c == 'E' || c == 'I' || c == 'O' ||c == 'U' || c == 'a' ||c == 'e' || c == 'i' || c == 'o' || c == 'u';
		});
	}
	
	public Stream<Character> getConsonants() {
		return this.str.chars().mapToObj(i -> (char)i).filter(c -> {
			return c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U' && c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u';
		});
	}

	// All String methods deligated
	public IntStream chars() {
		return str.chars();
	}

	public IntStream codePoints() {
		return str.codePoints();
	}

	public int length() {
		return str.length();
	}

	public boolean isEmpty() {
		return str.isEmpty();
	}

	public char charAt(int index) {
		return str.charAt(index);
	}

	public int codePointAt(int index) {
		return str.codePointAt(index);
	}

	public int codePointBefore(int index) {
		return str.codePointBefore(index);
	}

	public int codePointCount(int beginIndex, int endIndex) {
		return str.codePointCount(beginIndex, endIndex);
	}

	public int offsetByCodePoints(int index, int codePointOffset) {
		return str.offsetByCodePoints(index, codePointOffset);
	}

	public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
		str.getChars(srcBegin, srcEnd, dst, dstBegin);
	}

	public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
		return str.getBytes(charsetName);
	}

	public byte[] getBytes(Charset charset) {
		return str.getBytes(charset);
	}

	public byte[] getBytes() {
		return str.getBytes();
	}

	public boolean contentEquals(StringBuffer sb) {
		return str.contentEquals(sb);
	}

	public boolean contentEquals(CharSequence cs) {
		return str.contentEquals(cs);
	}

	public boolean equalsIgnoreCase(String anotherString) {
		return str.equalsIgnoreCase(anotherString);
	}

	public int compareTo(String anotherString) {
		return str.compareTo(anotherString);
	}

	public int compareToIgnoreCase(String str) {
		return str.compareToIgnoreCase(str);
	}

	public boolean regionMatches(int toffset, String other, int ooffset, int len) {
		return str.regionMatches(toffset, other, ooffset, len);
	}

	public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) {
		return str.regionMatches(ignoreCase, toffset, other, ooffset, len);
	}

	public boolean startsWith(String prefix, int toffset) {
		return str.startsWith(prefix, toffset);
	}

	public boolean startsWith(String prefix) {
		return str.startsWith(prefix);
	}

	public boolean endsWith(String suffix) {
		return str.endsWith(suffix);
	}

	public int indexOf(int ch) {
		return str.indexOf(ch);
	}

	public int indexOf(int ch, int fromIndex) {
		return str.indexOf(ch, fromIndex);
	}

	public int lastIndexOf(int ch) {
		return str.lastIndexOf(ch);
	}

	public int lastIndexOf(int ch, int fromIndex) {
		return str.lastIndexOf(ch, fromIndex);
	}

	public int indexOf(String str) {
		return str.indexOf(str);
	}

	public int indexOf(String str, int fromIndex) {
		return str.indexOf(str, fromIndex);
	}

	public int lastIndexOf(String str) {
		return str.lastIndexOf(str);
	}

	public int lastIndexOf(String str, int fromIndex) {
		return str.lastIndexOf(str, fromIndex);
	}

	public String substring(int beginIndex) {
		return str.substring(beginIndex);
	}

	public String substring(int beginIndex, int endIndex) {
		return str.substring(beginIndex, endIndex);
	}

	public CharSequence subSequence(int beginIndex, int endIndex) {
		return str.subSequence(beginIndex, endIndex);
	}

	public String concat(String str) {
		return str.concat(str);
	}

	public String replace(char oldChar, char newChar) {
		return str.replace(oldChar, newChar);
	}

	public boolean matches(String regex) {
		return str.matches(regex);
	}

	public boolean contains(CharSequence s) {
		return str.contains(s);
	}

	public String replaceFirst(String regex, String replacement) {
		return str.replaceFirst(regex, replacement);
	}

	public String replaceAll(String regex, String replacement) {
		return str.replaceAll(regex, replacement);
	}

	public String replace(CharSequence target, CharSequence replacement) {
		return str.replace(target, replacement);
	}

	public String[] split(String regex, int limit) {
		return str.split(regex, limit);
	}

	public String[] split(String regex) {
		return str.split(regex);
	}

	public String toLowerCase(Locale locale) {
		return str.toLowerCase(locale);
	}

	public String toLowerCase() {
		return str.toLowerCase();
	}

	public String toUpperCase(Locale locale) {
		return str.toUpperCase(locale);
	}

	public String toUpperCase() {
		return str.toUpperCase();
	}

	public String trim() {
		return str.trim();
	}

	public String toString() {
		return str.toString();
	}

	public char[] toCharArray() {
		return str.toCharArray();
	}

	public String intern() {
		return str.intern();
	}
	
}
