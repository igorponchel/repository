package OperateurDeTransportObjet.GestionnaireTransportObjetPackage;

/** 
 * Helper class for : ListeEtatObjet
 *  
 * @author OpenORB Compiler
 */ 
public class ListeEtatObjetHelper
{
    private static final boolean HAS_OPENORB;
    static {
        boolean hasOpenORB = false;
        try {
            Thread.currentThread().getContextClassLoader().loadClass("org.openorb.CORBA.Any");
            hasOpenORB = true;
        }
        catch(ClassNotFoundException ex) {
        }
        HAS_OPENORB = hasOpenORB;
    }
    /**
     * Insert ListeEtatObjet into an any
     * @param a an any
     * @param t ListeEtatObjet value
     */
    public static void insert(org.omg.CORBA.Any a, OperateurDeTransportObjet.EtatObjet[] t)
    {
        a.insert_Streamable(new OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ListeEtatObjetHolder(t));
    }

    /**
     * Extract ListeEtatObjet from an any
     * @param a an any
     * @return the extracted ListeEtatObjet value
     */
    public static OperateurDeTransportObjet.EtatObjet[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ListeEtatObjetHolder)
                    return ((OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ListeEtatObjetHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ListeEtatObjetHolder h = new OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ListeEtatObjetHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the ListeEtatObjet TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"ListeEtatObjet",orb.create_sequence_tc(0,OperateurDeTransportObjet.EtatObjetHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the ListeEtatObjet IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:OperateurDeTransportObjet/GestionnaireTransportObjet/ListeEtatObjet:1.0";

    /**
     * Read ListeEtatObjet from a marshalled stream
     * @param istream the input stream
     * @return the readed ListeEtatObjet value
     */
    public static OperateurDeTransportObjet.EtatObjet[] read(org.omg.CORBA.portable.InputStream istream)
    {
        OperateurDeTransportObjet.EtatObjet[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new OperateurDeTransportObjet.EtatObjet[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = OperateurDeTransportObjet.EtatObjetHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write ListeEtatObjet into a marshalled stream
     * @param ostream the output stream
     * @param value ListeEtatObjet value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, OperateurDeTransportObjet.EtatObjet[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            OperateurDeTransportObjet.EtatObjetHelper.write(ostream,value[i7]);

        }
    }

}
