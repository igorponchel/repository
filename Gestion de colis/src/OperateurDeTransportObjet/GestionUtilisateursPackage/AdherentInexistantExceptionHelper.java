package OperateurDeTransportObjet.GestionUtilisateursPackage;

/** 
 * Helper class for : AdherentInexistantException
 *  
 * @author OpenORB Compiler
 */ 
public class AdherentInexistantExceptionHelper
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
     * Insert AdherentInexistantException into an any
     * @param a an any
     * @param t AdherentInexistantException value
     */
    public static void insert(org.omg.CORBA.Any a, OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantException t)
    {
        a.insert_Streamable(new OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantExceptionHolder(t));
    }

    /**
     * Extract AdherentInexistantException from an any
     * @param a an any
     * @return the extracted AdherentInexistantException value
     */
    public static OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantException extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantExceptionHolder)
                    return ((OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantExceptionHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantExceptionHolder h = new OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantExceptionHolder(read(a.create_input_stream()));
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
     * Return the AdherentInexistantException TypeCode
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
                _tc = orb.create_exception_tc(id(),"AdherentInexistantException",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the AdherentInexistantException IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:OperateurDeTransportObjet/GestionUtilisateurs/AdherentInexistantException:1.0";

    /**
     * Read AdherentInexistantException from a marshalled stream
     * @param istream the input stream
     * @return the readed AdherentInexistantException value
     */
    public static OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantException read(org.omg.CORBA.portable.InputStream istream)
    {
        OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantException new_one = new OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantException();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();
        new_one.explication = istream.read_string();

        return new_one;
    }

    /**
     * Write AdherentInexistantException into a marshalled stream
     * @param ostream the output stream
     * @param value AdherentInexistantException value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantException value)
    {
        ostream.write_string(id());
        ostream.write_string(value.explication);
    }

}
