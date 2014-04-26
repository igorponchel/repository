package OperateurDeTransportObjet.GestionUtilisateursPackage;

/** 
 * Helper class for : TransInexistantException
 *  
 * @author OpenORB Compiler
 */ 
public class TransInexistantExceptionHelper
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
     * Insert TransInexistantException into an any
     * @param a an any
     * @param t TransInexistantException value
     */
    public static void insert(org.omg.CORBA.Any a, OperateurDeTransportObjet.GestionUtilisateursPackage.TransInexistantException t)
    {
        a.insert_Streamable(new OperateurDeTransportObjet.GestionUtilisateursPackage.TransInexistantExceptionHolder(t));
    }

    /**
     * Extract TransInexistantException from an any
     * @param a an any
     * @return the extracted TransInexistantException value
     */
    public static OperateurDeTransportObjet.GestionUtilisateursPackage.TransInexistantException extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof OperateurDeTransportObjet.GestionUtilisateursPackage.TransInexistantExceptionHolder)
                    return ((OperateurDeTransportObjet.GestionUtilisateursPackage.TransInexistantExceptionHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            OperateurDeTransportObjet.GestionUtilisateursPackage.TransInexistantExceptionHolder h = new OperateurDeTransportObjet.GestionUtilisateursPackage.TransInexistantExceptionHolder(read(a.create_input_stream()));
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
     * Return the TransInexistantException TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[1];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "explication";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_exception_tc(id(),"TransInexistantException",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the TransInexistantException IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:OperateurDeTransportObjet/GestionUtilisateurs/TransInexistantException:1.0";

    /**
     * Read TransInexistantException from a marshalled stream
     * @param istream the input stream
     * @return the readed TransInexistantException value
     */
    public static OperateurDeTransportObjet.GestionUtilisateursPackage.TransInexistantException read(org.omg.CORBA.portable.InputStream istream)
    {
        OperateurDeTransportObjet.GestionUtilisateursPackage.TransInexistantException new_one = new OperateurDeTransportObjet.GestionUtilisateursPackage.TransInexistantException();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();
        new_one.explication = istream.read_string();

        return new_one;
    }

    /**
     * Write TransInexistantException into a marshalled stream
     * @param ostream the output stream
     * @param value TransInexistantException value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, OperateurDeTransportObjet.GestionUtilisateursPackage.TransInexistantException value)
    {
        ostream.write_string(id());
        ostream.write_string(value.explication);
    }

}
