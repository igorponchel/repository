package OperateurDeTransportObjet;

/** 
 * Helper class for : CoordBancairePro
 *  
 * @author OpenORB Compiler
 */ 
public class CoordBancaireProHelper
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
     * Insert CoordBancairePro into an any
     * @param a an any
     * @param t CoordBancairePro value
     */
    public static void insert(org.omg.CORBA.Any a, OperateurDeTransportObjet.CoordBancairePro t)
    {
        a.insert_Streamable(new OperateurDeTransportObjet.CoordBancaireProHolder(t));
    }

    /**
     * Extract CoordBancairePro from an any
     * @param a an any
     * @return the extracted CoordBancairePro value
     */
    public static OperateurDeTransportObjet.CoordBancairePro extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof OperateurDeTransportObjet.CoordBancaireProHolder)
                    return ((OperateurDeTransportObjet.CoordBancaireProHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            OperateurDeTransportObjet.CoordBancaireProHolder h = new OperateurDeTransportObjet.CoordBancaireProHolder(read(a.create_input_stream()));
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
     * Return the CoordBancairePro TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[4];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "codeBanque";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "codeGuichet";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "numCompte";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "cleRIB";
                _members[3].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _tc = orb.create_struct_tc(id(),"CoordBancairePro",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the CoordBancairePro IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:OperateurDeTransportObjet/CoordBancairePro:1.0";

    /**
     * Read CoordBancairePro from a marshalled stream
     * @param istream the input stream
     * @return the readed CoordBancairePro value
     */
    public static OperateurDeTransportObjet.CoordBancairePro read(org.omg.CORBA.portable.InputStream istream)
    {
        OperateurDeTransportObjet.CoordBancairePro new_one = new OperateurDeTransportObjet.CoordBancairePro();

        new_one.codeBanque = istream.read_long();
        new_one.codeGuichet = istream.read_long();
        new_one.numCompte = istream.read_long();
        new_one.cleRIB = istream.read_long();

        return new_one;
    }

    /**
     * Write CoordBancairePro into a marshalled stream
     * @param ostream the output stream
     * @param value CoordBancairePro value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, OperateurDeTransportObjet.CoordBancairePro value)
    {
        ostream.write_long(value.codeBanque);
        ostream.write_long(value.codeGuichet);
        ostream.write_long(value.numCompte);
        ostream.write_long(value.cleRIB);
    }

}
