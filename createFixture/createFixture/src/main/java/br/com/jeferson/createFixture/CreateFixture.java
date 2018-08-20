package br.com.jeferson.createFixture;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public class CreateFixture {
	static String classname = "PessoaED";
	class FixtureED{
			
		public String anoNumeroProcesso;
		public Long nroIntProcesso;
		public Boolean bool;
		public Double doub;
		public Byte bite;
		public Integer  ite;
		public Long anoProcesso;
		public Long numeroProcesso;
		public Long nroIntPessoaProcesso;
		public Calendar menorDataInfracaoProcesso;
		public Calendar dataProcessoInscrito;
		public BigDecimal valorProcesso;
		public BigDecimal valorTotalProcesso;
		public InscricaoED inscricao;
		public PessoaProcessoED pessoaProcesso;
		public SituacaoProcessoEnum situacaoProcesso;
		public FaseED faseED;
		public Set<HistoricoInfracaoProcessoED> historicoInfracaoProcessoED;
		public SortedSet<InfracaoProcessoED> infracoesProcessoED;
		public Set<HistoricoProcessoFaseED> historicoProcessoFaseED;
		public Set<GuiaED> guias;
		public Set<MateriaDoeProcessoED> materiaDoeProcesso;
		public Set<RegistroArquivoCadinED> registrosArquivoCadin;
		public List<GuiaDividaAtivaGuiaInfracaoED> infracoesGuiaInformarSIT = new ArrayList<GuiaDividaAtivaGuiaInfracaoED>();

		public int primitiveInt;
		public double primDouble;
		public long primlong;
		public float primfloat;
		public boolean primboolean;
		public byte primbyte;
		public char primchar;
		

		class PessoaProcessoED {};
		class FaseED {};
		class SituacaoProcessoEnum {};
		class HistoricoInfracaoProcessoED {};
		class InfracaoProcessoED {};
		class HistoricoProcessoFaseED {};
		class GuiaED {};
		class MateriaDoeProcessoED {};
		class RegistroArquivoCadinED {};
		class InscricaoED {};
		class GuiaDividaAtivaGuiaInfracaoED {};
		
	}

	public static void main(String[] args) {
		
		Integer.toString(0);
		Class<FixtureED> classFixture = FixtureED.class;

		System.out.println("private static final String TEMPLATE_DADOS_DE_CONTROLE = \"TEMPLATE_DADOS_DE_CONTROLE\";");
		System.out.println("public static final String TEMPLATE_ALEATORIO         = \"TEMPLATE_ALEATORIO\";");
		System.out.println();
		System.out.println("Fixture.of("+classname+".class).addTemplate(TEMPLATE_DADOS_DE_CONTROLE, new Rule() {\r\n" + 
				"      {\r\n" + 
				"        add(\"ctrDthInc\", calendar);\r\n" + 
				"        add(\"ctrNroIpInc\", random((Object[]) IP));\r\n" + 
				"        add(\"ctrUsuInc\", 1L);\r\n" + 
				"        add(\"ctrOrgInc\", \"PROCERGS\");\r\n" + 
				"      }\r\n" + 
				"    });");
		
		
		
		
		
		
		System.out.println("Fixture.of("+classname+".class).addTemplate(TEMPLATE_ALEATORIO)."
				+ "inherits(TEMPLATE_DADOS_DE_CONTROLE, new Rule() {\r\n" + 
				"      {");
		
		
		
		
		for (Field field : classFixture.getFields()) {
			String defaultValue = "";
			//java.lang.Number
			//System.out.println("---------------------------");
			if (field.getType().isPrimitive()) {
				Object forClassName = InitializedObjectUtil.getForClassName(field.getType().getName());
				//System.out.println(forClassName!= null?forClassName.toString():"");
				defaultValue = forClassName!= null?forClassName.toString():"";
			}else {
				String stringClass = builtInMap.get(field.getType());
				//System.out.println(field.getType().getSimpleName() + " = " +stringClass);
				if(stringClass != null && !stringClass.equals("null")) {
					//System.out.println(InitializedObjectUtil.getForClassName(stringClass));
					defaultValue = InitializedObjectUtil.getForClassName(stringClass).toString();
				}
			}
			System.out.println("add(\""+field.getName()+"\","+defaultValue+");");
		}
		
		System.out.println("} });");
	}
	
	static Map<Class,String> builtInMap = new HashMap<Class,String>();
	static {
	       builtInMap.put(Integer.class,"int");
	       builtInMap.put(Long.class, "long");
	       builtInMap.put(Double.class, "double");
	       builtInMap.put(Float.class, "float");
	       builtInMap.put(Boolean.class, "boolean");
	       builtInMap.put(Character.class, "char");
	       builtInMap.put(String.class, "string");
	       builtInMap.put(Byte.class,"byte" );
	       builtInMap.put(Void.class,"void" );
	       builtInMap.put(Short.class,"short" );
	       builtInMap.put(BigDecimal.class,"bigdecimal" );
	       builtInMap.put(Calendar.class,"calendar" );
	}

}
