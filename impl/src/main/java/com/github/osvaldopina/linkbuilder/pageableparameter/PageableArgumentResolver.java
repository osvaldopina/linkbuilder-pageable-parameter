package com.github.osvaldopina.linkbuilder.pageableparameter;

import java.lang.reflect.Method;
import java.util.Arrays;

import com.github.osvaldopina.linkbuilder.template.Variable;
import com.github.osvaldopina.linkbuilder.template.VariableType;
import com.github.osvaldopina.linkbuilder.template.Variables;
import com.github.osvaldopina.linkbuilder.template.VariablesFactory;
import com.github.osvaldopina.linkbuilder.template.generation.argumentresolver.ArgumentResolver;
import com.github.osvaldopina.linkbuilder.utils.ReflectionUtils;
import org.springframework.data.domain.Pageable;

public class PageableArgumentResolver implements ArgumentResolver {

    private VariablesFactory variablesFactory = VariablesFactory.INSTANCE;

    @Override
    public boolean resolveFor(Method method, int parameterIndex) {


        return Pageable.class.isAssignableFrom(method.getParameterTypes()[parameterIndex]);
    }


    @Override
    public Variables create(Method method, int parameterIndex) {

        return variablesFactory.create(
                Arrays.asList(
                        new Variable("page", VariableType.QUERY, method, parameterIndex),
                        new Variable("size", VariableType.QUERY, method, parameterIndex),
                        new Variable("sort", VariableType.QUERY, method, parameterIndex)));

    }


}
