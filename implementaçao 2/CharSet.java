package segunda;

public class CharSet {
private int priority;
private String charSet;

public CharSet(String charSet) {
	this.charSet = charSet;
}


public String getCharSet() {
	return charSet;
}

public void setPriority(int priority) {
	this.priority = priority;
}

public int getPriority() {
	return priority;
}

public int size() {
	return charSet.length();
}
}
