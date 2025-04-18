public class FilaSimplesAtv implements IEstruturaSimples {

    private int tamanho;
    private Integer [] fila;

    public FilaSimplesAtv(int tamanho) {
        this.tamanho = tamanho;
        fila = new Integer[tamanho];
        System.out.println("Fila criada.");
    }

    @Override
    //certo
    public void inserirElemento(Object valor) {
        for (int i = 0; i < tamanho; i++) {
            if(this.fila[i] == null) {
                this.fila[i] = (Integer) valor;
                //System.out.println("Valor inserido["+i+"]: "+ valor);
                return;
            }
        }
        System.out.println("Valor " + valor + " não pode ser inserido. Lista cheia");
    }

    @Override
    //certo
    public void inserirElementoIndice(Object valor, int indice) {
        if (indice < 0 || indice >= tamanho) {
            System.out.println("Índice invalido");
            return;
        }

        for(int i = 0; i < tamanho; i++) {
            if(this.fila[indice] == null) {
                this.fila[indice] = (Integer) valor;
                System.out.println("Valor " + valor + " inserido no índice: " + indice );
                return;
            }
        }

        System.out.println("Indice já preenchido: " + indice);
    }

    @Override
    //certo
    public void inserirSequencia(Object valor) {
        if(estaCheia()) {
            System.out.println("Valor " + valor + " não pode ser inserido. Fila cheia");
            return;
        }
        for (int i = 0; i < tamanho; i++) {
            if (this.fila[i] == null) {
                this.fila[i] = (Integer) valor;
                System.out.println("Valor inserido[" + i + "]: " + valor);
                return;
            }
        }
    }

    @Override
    //certo
    public boolean removerElemento() {
        for (int i = 0; i < tamanho; i++) {
            if(this.fila[i] != null) {
                System.out.println("Removendo primeiro elemento da fila: " + this.fila[i]);
                this.fila[i] = null;
                return true;
            }
        }
        System.out.println("Nenhum elemento removido");
        return false;
    }

    @Override
    //certo
    public Object removerIndice(int indice) {
        if(indice < 0 || indice > tamanho - 1){
            System.out.println("Indice inválido");
            return null;
        }

        if (this.fila[indice] != null) {
            this.fila[indice] = null;
            System.out.println("Índice removido[" + indice + "]: " + this.fila[indice]);
        } else {
            System.out.println("Índice vazio");
        }

       return null;
    }

    @Override
    public void removerSequencia(Object valor) {
        if (estaVazia()) {
            System.out.println("Nenhum elemento para remover");
            return;
        }

        int quantidade = (int) valor;

        if (quantidade <= 0) {
            System.out.println("Quantidade inválida para remoção.");
            return;
        }

        int cont = 0;

        for (int i = 0; i < tamanho; i++) {
            if (fila[i] != null) {
                System.out.println("Valor removido [" + i + "]: " + fila[i]);
                fila[i] = null;
                cont++;
            }
            if (cont == quantidade) break;
        }

    }

    @Override
    //certo
    public void removerTodasOcorrencias(Object valor) {
        boolean encontrou = false;

        for (int i = 0; i < tamanho; i++) {
            if (this.fila[i] != null && this.fila[i].equals(valor)) {
                this.fila[i] = null;
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum elemento para remover");
        }
    }

    @Override
    //certo
    public boolean estaCheia() {
        for (int i = 0; i < tamanho; i++) {
            if (this.fila[i] == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    //certo
    public boolean estaVazia() {
        for (int i = 0; i < tamanho; i++) {
            if (this.fila[i] != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    //certo
    public boolean buscarElemento(Object valor) {
        for (int i = 0; i < tamanho; i++) {
            if (this.fila[i] == valor) {
                return true;
            }
        }
        return false;
    }

    @Override
    //certo
    public Object buscarElementoIndice(int indice) {
        if(indice >=0 && indice < tamanho) {
                if (this.fila[indice] != null) {
                    System.out.println("Elemento armazenado no indice ["+ indice +"]:" + this.fila[indice]);
                    return this.fila[indice];
                }else{
                    System.out.println("Indice vazio");
                }
        }
        else{
            System.out.println("Indice inválido");
            return null;
        }

        return null;
    }

    @Override
    //certo
    public void ordenarCrescente() {
        int aux;

        for (int i = 0; i < tamanho; i++) {
            if((i+1) < tamanho) {
                if (this.fila[i] > this.fila[i + 1]) {
                    aux = this.fila[i];
                    this.fila[i] = this.fila[i + 1];
                    this.fila[i + 1] = aux;
                    ordenarCrescente();
                }
            }
        }
    }

    @Override
    //certo
    public void ordenarDecrescente() {
        int aux;

        for (int i = tamanho - 1; i >= 0; i--) {
            if((i+1) < tamanho) {
                if (this.fila[i] < this.fila[i + 1]) {
                    aux = this.fila[i];
                    this.fila[i] = this.fila[i + 1];
                    this.fila[i + 1] = aux;
                    ordenarDecrescente();
                }
            }
        }

    }

    @Override
    //certo
    public int quantidadeElementos() {
        int cont = 0;
        for (int i = 0; i < tamanho; i++) {
            if(this.fila[i] != null) {
                cont++;
            }
        }
        return cont;
    }

    @Override
    public void dobrarCapacidade() {
        int tamanhox2 = this.tamanho*2;
        Integer[] fila2 = new Integer[tamanhox2];

        if(estaVazia()) {
            System.out.println("Não é possível aumentar a capacidade. Fila vazia");
        }else {
            for (int i = 0; i < tamanho; i++) {
                fila2[i] = this.fila[i];
            }
            System.out.println("Nova capacidade da lista: " + tamanhox2);
        }

        this.fila = fila2;
        this.tamanho = tamanhox2;
    }

    @Override
    //certo
    public void editarElemento(Object elementoAntigo, Object elementoNovo) {
        if(buscarElemento(elementoAntigo)) {
            for (int i = 0; i < tamanho; i++) {
                if(this.fila[i] == elementoAntigo) {
                    this.fila[i] = (Integer) elementoNovo;
                    System.out.println("Elemento na posição [" + i + "] alterado para: " + elementoNovo);
                }
            }
        }
        else{
            System.out.println("Elemento nao encontrado");
        }

    }

    @Override
    //certo
    public void limpar() {
            for (int i = 0; i < tamanho; i++) {
                if(this.fila[i] != null) {
                    this.fila[i] = null;
                }
            }
            System.out.println("Fila já está vazia");
    }

    @Override
    //certo
    public void exibir() {
        System.out.println("Exibindo elementos da fila.");
        for (int i = 0; i < this.tamanho; i++) {
            System.out.println("Fila[" + (i) + "] = " + this.fila[i]);
        }
    }

    @Override
    //certo
    public Object obterPrimeiroElemento() {
        for (int i = 0; i < tamanho; i++) {
            if (fila[i] != null) {
                System.out.println("Primeiro elemento não-nulo da fila: " + fila[i]);
                return fila[i];
            }
        }
        return "Lista vazia";
    }

    @Override
    //certo
    public Object obterUltimoElemento() {
        for (int i = tamanho - 1; i >= 0; i--) {
            if (fila[i] != null) {
                System.out.println("Ultimo elemento não-nulo da fila: " + fila[i]);
                return fila[i];
            }
        }
        return "Fila vazia";
    }
}
