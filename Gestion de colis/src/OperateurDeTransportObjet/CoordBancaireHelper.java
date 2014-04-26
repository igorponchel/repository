package OperateurDeTransportObjet;

/** 
 * Helper class for : CoordBancaire
 *  
 * @author OpenORB Compiler
 */ 
public class CoordBancaireHelper
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
     * Insert CoordBancaire into an any
     * @param a an any
     * @param t CoordBancaire value
     */
    public static void insert(org.omg.CORBA.Any a, OperateurDeTransportObjet.CoordBancaire t)
    {
        a.insert_Streamable(new OperateurDeTransportObjet.CoordBancaireHolder(t));
    }

    /**
     * Extract CoordBancaire from an any
     * @param a an any
     * @return the extracted CoordBancaire value
     */
    public static OperateurDeTransportObjet.CoordBancaire extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof OperateurDeTransportObjet.CoordBancaireHolder)
                    return ((OperateurDeTransportObjet.CoordBancaireHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            OperateurDeTransportObjet.CoordBancaireHolder h = new OperateurDeTransportObjet.CoordBancaireHolder(read(a.create_input_stream()));
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
     * Return the CoordBancaire TypeCode
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
                _members[0].name = "numeroCarte";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "proprietaire";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "date";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "numDos";
                _members[3].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _tc = orb.create_struct_tc(id(),"CoordBancaire",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the CoordBancaire IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:OperateurDeTransportObjet/CoordBancaire:1.0";

    /**
     * Read CoordBancaire from a marshalled stream
     * @param istream the input stream
     * @return the readed CoordBancaire value
     */
    public static OperateurDeTransportObjet.CoordBancaire read(org.omg.CORBA.portable.InputStream istream)
    {
        OperateurDeTransportObjet.CoordBancaire new_one = new OperateurDeTransportObjet.CoordBancaire();

        new_one.numeroCarte = istream.read_long();
        new_one.proprietaire = istream.read_string();
        new_one.date = istream.read_string();
        new_one.numDos = istream.read_long();

        return new_one;
    }

    /**
     * Write CoordBancaire into a marshalled stream
     * @param ostream the output stream
     * @param value CoordBancaire value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, OperateurDeTransportObjet.CoordBancaire value)
    {
        ostream.write_long(value.numeroCarte);
        ostream.write_string(value.proprietaire);
        ostream.write_string(value.date);
        ostream.write_long(value.numDos);
    }

}
