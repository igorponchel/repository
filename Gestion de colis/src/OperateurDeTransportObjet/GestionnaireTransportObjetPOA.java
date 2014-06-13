package OperateurDeTransportObjet;

/**
 * Interface definition : GestionnaireTransportObjet
 * 
 * @author OpenORB Compiler
 */
public abstract class GestionnaireTransportObjetPOA extends org.omg.PortableServer.Servant
        implements GestionnaireTransportObjetOperations, org.omg.CORBA.portable.InvokeHandler
{
    public GestionnaireTransportObjet _this()
    {
        return GestionnaireTransportObjetHelper.narrow(_this_object());
    }

    public GestionnaireTransportObjet _this(org.omg.CORBA.ORB orb)
    {
        return GestionnaireTransportObjetHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:OperateurDeTransportObjet/GestionnaireTransportObjet:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    private static final java.util.Map operationMap = new java.util.HashMap();

    static {
            operationMap.put("consulterEtatObjet",
                    new Operation_consulterEtatObjet());
            operationMap.put("demandeInscriptionTrans",
                    new Operation_demandeInscriptionTrans());
            operationMap.put("enregistrerObjet",
                    new Operation_enregistrerObjet());
            operationMap.put("notifierConnexion",
                    new Operation_notifierConnexion());
            operationMap.put("notifierDeconnexion",
                    new Operation_notifierDeconnexion());
            operationMap.put("notifierEtatObjet",
                    new Operation_notifierEtatObjet());
            operationMap.put("notifierOffreAcceptee",
                    new Operation_notifierOffreAcceptee());
            operationMap.put("notifierOffreTransport",
                    new Operation_notifierOffreTransport());
            operationMap.put("verifierTransporteur",
                    new Operation_verifierTransporteur());
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        final AbstractOperation operation = (AbstractOperation)operationMap.get(opName);

        if (null == operation) {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }

        return operation.invoke(this, _is, handler);
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_demandeInscriptionTrans(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        OperateurDeTransportObjet.GestionnaireTransportObjetPackage.DemandeInscriptionTrans arg0_in = OperateurDeTransportObjet.GestionnaireTransportObjetPackage.DemandeInscriptionTransHelper.read(_is);

        try
        {
            OperateurDeTransportObjet.GestionnaireTransportObjetPackage.InscriptionTrans _arg_result = demandeInscriptionTrans(arg0_in);

            _output = handler.createReply();
            OperateurDeTransportObjet.GestionnaireTransportObjetPackage.InscriptionTransHelper.write(_output,_arg_result);

        }
        catch (OperateurDeTransportObjet.GestionnaireTransportObjetPackage.TransExistantException _exception)
        {
            _output = handler.createExceptionReply();
            OperateurDeTransportObjet.GestionnaireTransportObjetPackage.TransExistantExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_notifierOffreTransport(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        String _arg_result = notifierOffreTransport(arg0_in, arg1_in);

        _output = handler.createReply();
        _output.write_string(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_notifierOffreAcceptee(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        String arg1_in = _is.read_string();

        String _arg_result = notifierOffreAcceptee(arg0_in, arg1_in);

        _output = handler.createReply();
        _output.write_string(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_verifierTransporteur(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        String arg1_in = _is.read_string();

        boolean _arg_result = verifierTransporteur(arg0_in, arg1_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_enregistrerObjet(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        OperateurDeTransportObjet.Objet arg0_in = OperateurDeTransportObjet.ObjetHelper.read(_is);

        enregistrerObjet(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_notifierEtatObjet(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        OperateurDeTransportObjet.EtatObjet arg1_in = OperateurDeTransportObjet.EtatObjetHelper.read(_is);

        try
        {
            notifierEtatObjet(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException _exception)
        {
            _output = handler.createExceptionReply();
            OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_consulterEtatObjet(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();

        try
        {
            OperateurDeTransportObjet.InfoObjet[] _arg_result = consulterEtatObjet(arg0_in);

            _output = handler.createReply();
            OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ListeInfoObjetHelper.write(_output,_arg_result);

        }
        catch (OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException _exception)
        {
            _output = handler.createExceptionReply();
            OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_notifierConnexion(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        OperateurDeTransportObjet.Transporteur arg1_in = OperateurDeTransportObjet.TransporteurHelper.read(_is);

        notifierConnexion(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_notifierDeconnexion(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();

        notifierDeconnexion(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    // operation classes
    private abstract static class AbstractOperation {
        protected abstract org.omg.CORBA.portable.OutputStream invoke(
                GestionnaireTransportObjetPOA target,
                org.omg.CORBA.portable.InputStream _is,
                org.omg.CORBA.portable.ResponseHandler handler);
    }

    private static final class Operation_demandeInscriptionTrans extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireTransportObjetPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_demandeInscriptionTrans(_is, handler);
        }
    }

    private static final class Operation_notifierOffreTransport extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireTransportObjetPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_notifierOffreTransport(_is, handler);
        }
    }

    private static final class Operation_notifierOffreAcceptee extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireTransportObjetPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_notifierOffreAcceptee(_is, handler);
        }
    }

    private static final class Operation_verifierTransporteur extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireTransportObjetPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_verifierTransporteur(_is, handler);
        }
    }

    private static final class Operation_enregistrerObjet extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireTransportObjetPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_enregistrerObjet(_is, handler);
        }
    }

    private static final class Operation_notifierEtatObjet extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireTransportObjetPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_notifierEtatObjet(_is, handler);
        }
    }

    private static final class Operation_consulterEtatObjet extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireTransportObjetPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_consulterEtatObjet(_is, handler);
        }
    }

    private static final class Operation_notifierConnexion extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireTransportObjetPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_notifierConnexion(_is, handler);
        }
    }

    private static final class Operation_notifierDeconnexion extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireTransportObjetPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_notifierDeconnexion(_is, handler);
        }
    }

}
