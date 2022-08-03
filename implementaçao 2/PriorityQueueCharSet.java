//Aluno:Vinicius Domingues Pereira RA:2409186

import java.util.ArrayList;

public class PriorityQueueCharSet implements PriorityQueue<String> {
	ArrayList<CharSet> charSets = new ArrayList<CharSet>();

	// metodo que retorna um booleano se a fila esta vazia ou nao
	public boolean isEmpty() {
		return charSets.isEmpty();
	}

	// metodo utilizado para retornar o tamanho da fila
	public int size() {
		return charSets.size();
	}

	// metodo para buscar o elemento com maior prioridade que é indice 0 pois a fila
	// esta ordenada
	public String findMax() {
		return charSets.get(0).getCharSet();
	}

	// metodo para inserir um elemento na fila
	public void insert(String charset) {
		CharSet element = new CharSet(charset);
		// verifica se a fila esta vazia caso esteja o elemento tem prioridade 1
		if (isEmpty()) {
			element.setPriority(1);
			charSets.add(element);
		} else {
			int pos = -1;
			int size = charSets.size();
			boolean inseriu = true;
			// for utilizado para percorrer todos os elementos da lista
			for (CharSet obj : charSets) {
				pos++;
				// verifica se o elemento é menos doque o objeto que ja esta na fila
				if (element.size() < obj.size()) {
					element.setPriority(pos + 1);
					charSets.add(pos, element);
					pos++;

					// for utilizado para setar a prioridade dos demais elementos da fila
					for (int i = pos; i <= charSets.size() - 1; i++) {
						charSets.get(i).setPriority(i + 1);
					}
					inseriu = false;
					break;
				}
				// caso o elemento nao seja menos aqui ele verifica se é igual
				if (element.size() == obj.size()) {
					// entao ele compara lexograficamente os dois para determinar suas posições
					if (element.getCharSet().compareTo(obj.getCharSet()) < 0) {
						element.setPriority(pos + 1);
						charSets.add(pos, element);
						pos++;
						for (int i = pos; i <= charSets.size() - 1; i++) {

							charSets.get(i).setPriority(i + 1);
						}
						inseriu = false;
						break;
					}
				}
			}
			if (inseriu) {
				element.setPriority(size + 1);
				charSets.add(element);
			}
		}
	}

	// metodo utilizado para deletar o elemento prioritario e retornalo
	public String deleteMax() {
		String delet = charSets.remove(0).getCharSet();
		int contador = 1;
		for (CharSet obj : charSets) {
			obj.setPriority(contador);
			contador++;
		}
		return delet;
	}

	// esvazia a fila de uma so vez
	public void makeEmpty() {
		charSets.clear();
	}

	// muda a prioridade do elemento para a prioridade p
	public boolean changePriority(int indice, int prioridade) {
		if (isEmpty()) {
			return false;
		}
		if (indice > size() || indice < 0) {
			return false;
		}
		CharSet aux = charSets.get(indice);

		aux.setPriority(prioridade);
		charSets.remove(indice);
		sort(indice, prioridade, aux);

		return true;
	}

	// metodo utilizado para reoorganizar os elementos na fila depois de mudar a
	// prioridade de um...
	private void sort(int indice, int prioridade, CharSet aux) {
		if (prioridade < indice) {
			charSets.add(prioridade - 1, aux);
			for (int e = prioridade; e <= size() - 1; e++) {
				prioridade++;
				charSets.get(e).setPriority(prioridade);
			}
		} else {

			charSets.add(prioridade - 1, aux);

			for (int e = prioridade - 2; e >= 1; e--) {
				prioridade--;
				charSets.get(e).setPriority(prioridade);
			}
		}

	}

	// metodo para facilitar o entendimento das mudanças de prioridade
	public String printar() {
		String str = "";
		for (CharSet obj : charSets) {
			str += " " + obj.getCharSet() + " - " + obj.getPriority() + "\n";
		}
		return str;
	}
}
