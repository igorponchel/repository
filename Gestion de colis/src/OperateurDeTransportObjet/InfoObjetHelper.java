package OperateurDeTransportObjet;

/** 
 * Helper class for : InfoObjet
 *  
 * @author OpenORB Compiler
 */ 
public class InfoObjetHelper
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
     * Insert InfoObjet into an any
     * @param a an any
     * @param t InfoObjet value
     */
    public static void insert(org.omg.CORBA.Any a, OperateurDeTransportObjet.InfoObjet t)
    {
        a.insert_Streamable(new OperateurDeTransportObjet.InfoObjetHolder(t));
    }

    /**
     * Extract InfoObjet from an any
     * @param a an any
     * @return the extracted InfoObjet value
     */
    public static OperateurDeTransportObjet.InfoObjet extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof OperateurDeTransportObjet.InfoObjetHolder)
                    return ((OperateurDeTransportObjet.InfoObjetHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            OperateurDeTransportObjet.InfoObjetHolder h = new OperateurDeTransportObjet.InfoObjetHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;
    private static boolean _working = false;

    /**
     * Return the InfoObjet TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            synchronized(org.omg.CORBA.TypeCode.class) {
                if (_tc != null)
                    return _tc;
                if (_working)
                    return org.omg.CORBA.ORB.init().create_recursive_tc(id());
                _working = true;
                org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[2];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "idObjet";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "etatObjet";
                _members[1].type = OperateurDeTransportObjet.EtatObjetHelper.type();
                _tc = orb.create_struct_tc(id(),"InfoObjet",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the InfoObjet IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:OperateurDeTransportObjet/InfoObjet:1.0";

    /**
     * Read InfoObjet from a marshalled stream
     * @param istream the input stream
     * @return the readed InfoObjet value
     */
    public static OperateurDeTransportObjet.InfoObjet read(org.omg.CORBA.portable.InputStream istream)
    {
        OperateurDeTransportObjet.InfoObjet new_one = new OperateurDeTransportObjet.InfoObjet();

        new_one.idObjet = istream.read_string();
        new_one.etatObjet = OperateurDeTransportObjet.EtatObjetHelper.read(istream);

        return new_one;
    }

    /**
     * Write InfoObjet into a marshalled stream
     * @param ostream the output stream
     * @param value InfoObjet value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, OperateurDeTransportObjet.InfoObjet value)
    {
        ostream.write_string(value.idObjet);
        OperateurDeTransportObjet.EtatObjetHelper.write(ostream,value.etatObjet);
    }

}
