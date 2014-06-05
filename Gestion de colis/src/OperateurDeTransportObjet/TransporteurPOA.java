package OperateurDeTransportObjet;

/**
 * Interface definition : Transporteur
 * 
 * @author OpenORB Compiler
 */
public abstract class TransporteurPOA extends org.omg.PortableServer.Servant
        implements TransporteurOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Transporteur _this()
    {
        return TransporteurHelper.narrow(_this_object());
    }

    public Transporteur _this(org.omg.CORBA.ORB orb)
    {
        return TransporteurHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:OperateurDeTransportObjet/Transporteur:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("notifierOffrePriseEnCharge")) {
                return _invoke_notifierOffrePriseEnCharge(_is, handler);
        } else if (opName.equals("notifierOffreTransport")) {
                return _invoke_notifierOffreTransport(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_notifierOffreTransport(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();

        notifierOffreTransport(arg0_in, arg1_in, arg2_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_notifierOffrePriseEnCharge(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        notifierOffrePriseEnCharge(arg0_in);

        _output = handler.createReply();

        return _output;
    }

}
