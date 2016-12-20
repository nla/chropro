#!/bin/bash

mvn -pl codegen package dependency:copy-dependencies && java -cp "codegen/target/*:codegen/target/dependency/*" chropro.Codegen client/src/