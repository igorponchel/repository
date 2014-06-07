package OperateurDeTransportObjet.GestionnaireTransportObjetPackage;

/** 
 * Helper class for : ListeInfoObjet
 *  
 * @author OpenORB Compiler
 */ 
public class ListeInfoObjetHelper
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
     * Insert ListeInfoObjet into an any
     * @param a an any
     * @param t ListeInfoObjet value
     */
    public static void insert(org.omg.CORBA.Any a, OperateurDeTransportObjet.InfoObjet[] t)
    {
        a.insert_Streamable(new OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ListeInfoObjetHolder(t));
    }

    /**
     * Extract ListeInfoObjet from an any
     * @param a an any
     * @return the extracted ListeInfoObjet value
     */
    public static OperateurDeTransportObjet.InfoObjet[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ListeInfoObjetHolder)
                    return ((OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ListeInfoObjetHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ListeInfoObjetHolder h = new OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ListeInfoObjetHolder(read(a.create_input_stream()));
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
     * Return the ListeInfoObjet TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"ListeInfoObjet",orb.create_sequence_tc(0,OperateurDeTransportObjet.InfoObjetHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the ListeInfoObjet IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:OperateurDeTransportObjet/GestionnaireTransportObjet/ListeInfoObjet:1.0";

    /**
     * Read ListeInfoObjet from a marshalled stream
     * @param istream the input stream
     * @return the readed ListeInfoObjet value
     */
    public static OperateurDeTransportObjet.InfoObjet[] read(org.omg.CORBA.portable.InputStream istream)
    {
        OperateurDeTransportObjet.InfoObjet[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new OperateurDeTransportObjet.InfoObjet[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = OperateurDeTransportObjet.InfoObjetHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write ListeInfoObjet into a marshalled stream
     * @param ostream the output stream
     * @param value ListeInfoObjet value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, OperateurDeTransportObjet.InfoObjet[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            OperateurDeTransportObjet.InfoObjetHelper.write(ostream,value[i7]);

        }
    }

}
