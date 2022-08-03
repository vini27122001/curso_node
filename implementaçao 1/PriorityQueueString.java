//Aluno:Vinicius Domingues Pereira RA:2409186

public class PriorityQueueString implements PriorityQueue<String>{
	private Link head;
	
	public PriorityQueueString(){
		this.head = null;
		
	}
	
	// metodo que retorna um booleano se a fila esta vazia ou nao 
	public boolean isEmpty() {
		return head == null;
	} 
	
	// metodo utilizado para retornar o tamanho da fila 
	public int size(){
		int lenght = 0;
		  for (Link aux = head; aux != null; aux = aux.next) {
			  lenght++;
		  }
		  return lenght;
		
	} 

	//metodo para procurar o menor elemento da lista
	private int menorelemento() {
		int tamanhomenor = head.data.length();
		for (Link aux = head; aux != null; aux = aux.next) {
			if(aux.data.length() < tamanhomenor) {
				tamanhomenor = aux.data.length();
				
			}
			
		}
		return tamanhomenor;
		}

	// metodo para buscar o elemento com maior prioridade que é indice 0 pois a fila esta ordenada
	public String findMax(){
		String concorrente = "";
		int menor = menorelemento();
		for (Link aux = head; aux != null; aux = aux.next) {
			  if(aux.data.length() == menor && concorrente.equals("")){
				  
				  concorrente = aux.data;
			  }
			  if(aux.data.compareTo(concorrente) < 0 && aux.data.length() == menor) {
				  concorrente = aux.data;
			 }
		  }
		return concorrente;
	};

	//metodo para inserir um elemento na lista
	public void insert (String obj) {
		 Link link = new Link(obj);
	        
	  	  if(isEmpty()){
	            head = link;
	        }
	        else
	        {
	      	  Link aux = head;
	            while(aux.next != null){
	                aux = aux.next;
	            } 
	            aux.next  = link;
	        }
	} ;

	//metodo para remover o elemento prioritario da lista
	public String deleteMax() {
		String excluido = findMax();
		if(head.data == excluido) {
			head = head.next;
			return excluido;
		}else {
        Link sucessor = null, prev = null; Link aux = head;

        while (aux.next != null) {
            if (aux.next.data.equals(findMax()) == true) {
                 prev = aux;
                sucessor = aux.next.next;

                break;
                }
            aux = aux.next;
        }

        prev.next = sucessor;

        return excluido;
	}}

	//metodo para esvaziar toda a lista
	public void makeEmpty() {
		while(!isEmpty()) {
	        deleteMax();
	    }
	} ;
}
