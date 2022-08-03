

public class Link {
	public Link next; 
	public String data;
	    
	    public Link (String data){
	    	this.data = data; 
	    	this.next = null;
	    }

	    public String toString() {
	        return data.toString();
	    }
}
