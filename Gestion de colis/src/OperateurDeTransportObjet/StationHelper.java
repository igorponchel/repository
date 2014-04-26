package OperateurDeTransportObjet;

/** 
 * Helper class for : Station
 *  
 * @author OpenORB Compiler
 */ 
public class StationHelper
{
    /**
     * Insert Station into an any
     * @param a an any
     * @param t Station value
     */
    public static void insert(org.omg.CORBA.Any a, OperateurDeTransportObjet.Station t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Station from an any
     * @param a an any
     * @return the extracted Station value
     */
    public static OperateurDeTransportObjet.Station extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return OperateurDeTransportObjet.StationHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Station TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Station");
        }
        return _tc;
    }

    /**
     * Return the Station IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:OperateurDeTransportObjet/Station:1.0";

    /**
     * Read Station from a marshalled stream
     * @param istream the input stream
     * @return the readed Station value
     */
    public static OperateurDeTransportObjet.Station read(org.omg.CORBA.portable.InputStream istream)
    {
        return(OperateurDeTransportObjet.Station)istream.read_Object(OperateurDeTransportObjet._StationStub.class);
    }

    /**
     * Write Station into a marshalled stream
     * @param ostream the output stream
     * @param value Station value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, OperateurDeTransportObjet.Station value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Station
     * @param obj the CORBA Object
     * @return Station Object
     */
    public static Station narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Station)
            return (Station)obj;

        if (obj._is_a(id()))
        {
            _StationStub stub = new _StationStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Station
     * @param obj the CORBA Object
     * @return Station Object
     */
    public static Station unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Station)
            return (Station)obj;

        _StationStub stub = new _StationStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
