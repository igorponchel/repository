package OperateurDeTransportObjet;

/**
 * Interface definition : GestionnairePaiement
 * 
 * @author OpenORB Compiler
 */
public abstract class GestionnairePaiementPOA extends org.omg.PortableServer.Servant
        implements GestionnairePaiementOperations, org.omg.CORBA.portable.InvokeHandler
{
    public GestionnairePaiement _this()
    {
        return GestionnairePaiementHelper.narrow(_this_object());
    }

    public GestionnairePaiement _this(org.omg.CORBA.ORB orb)
    {
        return GestionnairePaiementHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:OperateurDeTransportObjet/GestionnairePaiement:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("crediter")) {
                return _invoke_crediter(_is, handler);
        } else if (opName.equals("debiter")) {
                return _invoke_debiter(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_debiter(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        OperateurDeTransportObjet.CoordBancaire arg0_in = OperateurDeTransportObjet.CoordBancaireHelper.read(_is);
        int arg1_in = _is.read_long();

        short _arg_result = debiter(arg0_in, arg1_in);

        _output = handler.createReply();
        _output.write_short(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_crediter(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        OperateurDeTransportObjet.CoordBancairePro arg0_in = OperateurDeTransportObjet.CoordBancaireProHelper.read(_is);
        int arg1_in = _is.read_long();

        short _arg_result = crediter(arg0_in, arg1_in);

        _output = handler.createReply();
        _output.write_short(_arg_result);

        return _output;
    }

}
