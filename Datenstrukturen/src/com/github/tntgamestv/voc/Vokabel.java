/**
 * 
 */
package com.github.tntgamestv.voc;

/**
 * @author TnTGamesTV Project: Datenstrukturen Date: 21-11-2017
 */
public class Vokabel {

	public enum Language {
		GERMAN, ENGLISH;
	}

	private String		key;
	private String		content;

	private Language	type;

	private Vokabel		partner;

	public Vokabel(String key, String content, Language type) {
		this.key = key;
		this.content = content;
		this.type = type;
	}

	@Override
	public String toString() {
		return key + ": " + content;
	}

	public boolean link(Vokabel partner) {
		// Need to have the same key
		if (!this.key.equalsIgnoreCase(partner.key)) {
			return false;
		}

		// Diffrent type (e.g. GERMAN and ENGLISH)
		if (this.type == partner.type) {
			return false;
		}

		// Set partner
		partner.partner = this;
		this.partner = partner;
		return true;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @return the type
	 */
	public Language getType() {
		return type;
	}

	/**
	 * @return the partner
	 */
	public Vokabel getPartner() {
		return partner;
	}
}
