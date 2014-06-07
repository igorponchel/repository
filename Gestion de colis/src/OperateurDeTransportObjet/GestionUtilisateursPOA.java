package OperateurDeTransportObjet;

/**
 * Interface definition : GestionUtilisateurs
 * 
 * @author OpenORB Compiler
 */
public abstract class GestionUtilisateursPOA extends org.omg.PortableServer.Servant
        implements GestionUtilisateursOperations, org.omg.CORBA.portable.InvokeHandler
{
    public GestionUtilisateurs _this()
    {
        return GestionUtilisateursHelper.narrow(_this_object());
    }

    public GestionUtilisateurs _this(org.omg.CORBA.ORB orb)
    {
        return GestionUtilisateursHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:OperateurDeTransportObjet/GestionUtilisateurs:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    private static final java.util.Map operationMap = new java.util.HashMap();

    static {
            operationMap.put("demandeAdhesion",
                    new Operation_demandeAdhesion());
            operationMap.put("demandeInscriptionTrans",
                    new Operation_demandeInscriptionTrans());
            operationMap.put("getAdherentSiConnecte",
                    new Operation_getAdherentSiConnecte());
            operationMap.put("getNumAdherent",
                    new Operation_getNumAdherent());
            operationMap.put("getZoneAdherent",
                    new Operation_getZoneAdherent());
            operationMap.put("notifierConnexion",
                    new Operation_notifierConnexion());
            operationMap.put("notifierConnexionAdh",
                    new Operation_notifierConnexionAdh());
            operationMap.put("notifierDeconnexion",
                    new Operation_notifierDeconnexion());
            operationMap.put("notifierDeconnexionAdh",
                    new Operation_notifierDeconnexionAdh());
            operationMap.put("verifierAdherent",
                    new Operation_verifierAdherent());
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
    private org.omg.CORBA.portable.OutputStream _invoke_demandeAdhesion(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesion arg0_in = OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesionHelper.read(_is);

        try
        {
            OperateurDeTransportObjet.GestionUtilisateursPackage.Adhesion _arg_result = demandeAdhesion(arg0_in);

            _output = handler.createReply();
            OperateurDeTransportObjet.GestionUtilisateursPackage.AdhesionHelper.write(_output,_arg_result);

        }
        catch (OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentExistantException _exception)
        {
            _output = handler.createExceptionReply();
            OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentExistantExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_demandeInscriptionTrans(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeInscriptionTrans arg0_in = OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeInscriptionTransHelper.read(_is);

        try
        {
            OperateurDeTransportObjet.GestionUtilisateursPackage.InscriptionTrans _arg_result = demandeInscriptionTrans(arg0_in);

            _output = handler.createReply();
            OperateurDeTransportObjet.GestionUtilisateursPackage.InscriptionTransHelper.write(_output,_arg_result);

        }
        catch (OperateurDeTransportObjet.GestionUtilisateursPackage.TransExistantException _exception)
        {
            _output = handler.createExceptionReply();
            OperateurDeTransportObjet.GestionUtilisateursPackage.TransExistantExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_verifierAdherent(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        String arg1_in = _is.read_string();

        boolean _arg_result = verifierAdherent(arg0_in, arg1_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_verifierTransporteur(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();

        boolean _arg_result = verifierTransporteur(arg0_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getNumAdherent(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        try
        {
            int _arg_result = getNumAdherent(arg0_in, arg1_in);

            _output = handler.createReply();
            _output.write_long(_arg_result);

        }
        catch (OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantException _exception)
        {
            _output = handler.createExceptionReply();
            OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getZoneAdherent(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        try
        {
            int _arg_result = getZoneAdherent(arg0_in, arg1_in);

            _output = handler.createReply();
            _output.write_long(_arg_result);

        }
        catch (OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantException _exception)
        {
            _output = handler.createExceptionReply();
            OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantExceptionHelper.write(_output,_exception);
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

    private org.omg.CORBA.portable.OutputStream _invoke_notifierConnexionAdh(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        OperateurDeTransportObjet.Adherent arg1_in = OperateurDeTransportObjet.AdherentHelper.read(_is);

        notifierConnexionAdh(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_notifierDeconnexionAdh(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();

        notifierDeconnexionAdh(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getAdherentSiConnecte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();

        OperateurDeTransportObjet.Adherent _arg_result = getAdherentSiConnecte(arg0_in);

        _output = handler.createReply();
        OperateurDeTransportObjet.AdherentHelper.write(_output,_arg_result);

        return _output;
    }

    // operation classes
    private abstract static class AbstractOperation {
        protected abstract org.omg.CORBA.portable.OutputStream invoke(
                GestionUtilisateursPOA target,
                org.omg.CORBA.portable.InputStream _is,
                org.omg.CORBA.portable.ResponseHandler handler);
    }

    private static final class Operation_demandeAdhesion extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionUtilisateursPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_demandeAdhesion(_is, handler);
        }
    }

    private static final class Operation_demandeInscriptionTrans extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionUtilisateursPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_demandeInscriptionTrans(_is, handler);
        }
    }

    private static final class Operation_verifierAdherent extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionUtilisateursPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_verifierAdherent(_is, handler);
        }
    }

    private static final class Operation_verifierTransporteur extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionUtilisateursPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_verifierTransporteur(_is, handler);
        }
    }

    private static final class Operation_getNumAdherent extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionUtilisateursPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getNumAdherent(_is, handler);
        }
    }

    private static final class Operation_getZoneAdherent extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionUtilisateursPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getZoneAdherent(_is, handler);
        }
    }

    private static final class Operation_notifierConnexion extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionUtilisateursPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_notifierConnexion(_is, handler);
        }
    }

    private static final class Operation_notifierDeconnexion extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionUtilisateursPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_notifierDeconnexion(_is, handler);
        }
    }

    private static final class Operation_notifierConnexionAdh extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionUtilisateursPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_notifierConnexionAdh(_is, handler);
        }
    }

    private static final class Operation_notifierDeconnexionAdh extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionUtilisateursPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_notifierDeconnexionAdh(_is, handler);
        }
    }

    private static final class Operation_getAdherentSiConnecte extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionUtilisateursPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getAdherentSiConnecte(_is, handler);
        }
    }

}
