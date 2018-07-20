package br.com.w2tec.cursomc.domain.enums;

public enum TipoCliente {
	PESSOAFISICA(1, "Pessoa Física"), 
	PESSOAJURIDICA(2,"Pessoa Jurídica");
	
	private int cod;
	private String descrcao;

	private TipoCliente(int cod, String descrcao) {
		this.cod = cod;
		this.descrcao = descrcao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescrcao() {
		return descrcao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if (cod == null) { 
			return null;
		}
		
		for(TipoCliente x: TipoCliente.values()) { 
			if (cod.equals(x.getCod())) { 
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	

}
