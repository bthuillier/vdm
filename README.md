# VDM post project

## Requirement

Having SBT installed: [Installation](http://www.scala-sbt.org/release/tutorial/Setup.html)

## How to run it

The default clock is the system clock. It can be changed to a specific
date before launching the BidEngine server:

1. launching test `sbt test`
2. run the vdm parser `sbt 'runMain com.bthuillier.vdm.VDMParser'`
3. run the server `sbt 'runMain com.bthuillier.vdm.VDM'`
