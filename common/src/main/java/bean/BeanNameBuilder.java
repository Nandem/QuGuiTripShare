package bean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * @author Nandem on 2017-05-09.
 */
public class BeanNameBuilder extends AnnotationBeanNameGenerator
{
    @Override
    protected String buildDefaultBeanName(BeanDefinition definition)
    {
        String className = definition.getBeanClassName();

        className = className.substring(className.lastIndexOf(".") + 1);
        if(className.toLowerCase().endsWith("impl"))
        {
            className = className.substring(0, className.length() - 4);
        }
        if(!(className.toLowerCase().endsWith("service") || className.toLowerCase().endsWith("dao")))
        {
            return super.buildDefaultBeanName(definition);
        }


        className = className.substring(0, 1).toLowerCase() + className.substring(1);
        return className;
    }
}
