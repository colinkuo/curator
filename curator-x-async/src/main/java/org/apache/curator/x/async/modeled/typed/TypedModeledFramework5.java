package org.apache.curator.x.async.modeled.typed;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.x.async.modeled.ModeledFramework;
import org.apache.curator.x.async.modeled.ModeledFrameworkBuilder;

@FunctionalInterface
public interface TypedModeledFramework5<M, P1, P2, P3, P4, P5>
{
    ModeledFramework<M> resolved(CuratorFramework client, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5);

    /**
     * Return a new TypedModeledFramework using the given modeled framework builder and typed model spec.
     * When {@link #resolved(CuratorFramework, Object, Object, Object, Object, Object)} is called the actual ModeledFramework is generated with the
     * resolved model spec
     *
     * @param frameworkBuilder ModeledFrameworkBuilder
     * @param modelSpec TypedModelSpec
     * @return new TypedModeledFramework
     */
    static <M, P1, P2, P3, P4, P5> TypedModeledFramework5<M, P1, P2, P3, P4, P5> from(ModeledFrameworkBuilder<M> frameworkBuilder, TypedModelSpec5<M, P1, P2, P3, P4, P5> modelSpec)
    {
        return (client, p1, p2, p3, p4, p5) -> frameworkBuilder.withClient(client).withModelSpec(modelSpec.resolved(p1, p2, p3, p4, p5)).build();
    }
}