package pro.jpa2.util;


import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class uses CDI to alias Java EE resources, such as the persistence context, to CDI beans
 *
 * <p>
 * Example injection on a managed bean field:
 * </p>
 *
 * <pre>
 * &#064;Inject
 * private EntityManager em;
 * </pre>
 */
public class Resources {
   @Produces
   @PersistenceContext
   private EntityManager em;

   @Produces
   public CriteriaBuilder produceCriteriaBuilder(){
	   return em.getCriteriaBuilder();
   }

   @Produces
   public Logger produceLog(InjectionPoint injectionPoint) {
      return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
   }
}
